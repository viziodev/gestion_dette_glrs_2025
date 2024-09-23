package com.ism.core.repository.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ism.core.database.impl.DatabaseImpl;
import com.ism.core.repository.AbstractEntity;
import com.ism.core.repository.DatabaseRepository;
import java.lang.reflect.Field;
import java.sql.*;

public class CrudRepository<T extends AbstractEntity, ID> extends DatabaseImpl
        implements DatabaseRepository<T, ID> {
    private final Class<T> type;

    public CrudRepository(Class<T> type) {
        this.type = type;
    }

    @Override
    public T insert(T entity, String... exceptColumnNames) throws Exception {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(getTableName()).append(" (");
        // Construction de la liste des champs
        Field[] fields = type.getDeclaredFields();
        List<String> exceptColumnNamesList = Arrays.asList(exceptColumnNames);
        List<Object> values = new ArrayList<>();
        List<String> columnNamesList = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            if (!exceptColumnNamesList.contains(field.getName())) {
                columnNamesList.add(field.getName());
                values.add(field.get(entity));
            }

        }
        query.append(String.join(", ", columnNamesList)).append(") VALUES (");
        query.append("?,".repeat(columnNamesList.size()));
        query.deleteCharAt(query.length() - 1); // Supprimer la dernière virgule
        query.append(")");

        // Exécuter la requête
        this.executeUpdate(query.toString(), values.toArray());
        // ResultSet rs = statement.getGeneratedKeys();
        // if (rs.next()) {
        // entity.setId(rs.getInt(1));
        // }
        return entity;
    }

    @Override
    public T find(ID id) throws Exception {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        ResultSet rs = this.executeQuery(query, id);
        if (rs.next()) {
            return relationToObject(rs);
        }
        return null;
    }

    @Override
    public void update(T entity) throws Exception {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(getTableName()).append(" SET ");

        Field[] fields = type.getDeclaredFields();
        List<Object> values = new ArrayList<>();
        Integer id = null;
        for (Field field : fields) {
            // field.setAccessible(true);
            if ("id".equals(field.getName())) {
                id = (Integer) field.get(entity); // On prend l'id
                continue;
            }
            query.append(field.getName()).append(" = ?, ");
            values.add(field.get(entity));
        }

        query.delete(query.length() - 2, query.length()); // Supprimer la dernière virgule
        query.append(" WHERE id = ?");
        values.add(id);

        this.executeUpdate(query.toString(), values.toArray());
    }

    @Override
    public void delete(ID id) throws Exception {
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?";
        this.executeUpdate(query, id);
    }

    @Override
    public List<T> selectAll(String... columnNames) throws Exception {
        String query = "SELECT * FROM " + getTableName();
        ResultSet rs = this.executeQuery(query);
        List<T> results = new ArrayList<>();
        while (rs.next()) {
            results.add(relationToObject(rs, columnNames));
        }
        return results;
    }

    protected String getTableName() {
        return type.getSimpleName().toLowerCase() + "s"; // Convertit en minuscules et ajoute "s"
    }

    protected T relationToObject(ResultSet rs, String... columnNames) throws Exception {
        T entity = type.getDeclaredConstructor().newInstance();
        List<String> columnNamesList = Arrays.asList(columnNames);
        Field[] fields = type.getDeclaredFields();
        int columnNamesLength = fields.length;
        if (columnNames.length != 0) {
            columnNamesLength = columnNames.length;
        }
        for (int i = 0; i < columnNamesLength; i++) {
            Field field = fields[i];
            if (columnNamesList.contains(field.getName())) {
                field.setAccessible(true);
                field.set(entity, rs.getObject(field.getName()));
            }

        }
        return entity;
    }

}
