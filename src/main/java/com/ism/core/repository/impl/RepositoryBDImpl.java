package com.ism.core.repository.impl;

import com.ism.core.database.impl.DatabaseImpl;
import com.ism.core.repository.Repository;
import java.sql.*;

public abstract class RepositoryBDImpl<T> extends DatabaseImpl implements Repository<T> {
    // Creer les methodes insert et selectAll par reflexion
    protected String tableName;
    public abstract T convertToObject(ResultSet rs) throws SQLException;
    @Override
    public void remove(Integer id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public T selectById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
