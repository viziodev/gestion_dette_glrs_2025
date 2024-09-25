package com.ism.core.repository.impl;

import java.util.List;



import com.ism.core.database.impl.DatabaseImpl;
import com.ism.core.repository.AbstractEntity;
import com.ism.core.repository.DatabaseRepository;
import java.lang.reflect.*;
import java.sql.*;

public abstract class RepositoryBD<T extends AbstractEntity, ID> extends DatabaseImpl
        implements DatabaseRepository<T, ID> {
    private final Class<T> type;

    public RepositoryBD(Class<T> type) {
        this.type = type;
    }
    protected abstract String sqlInsert();
    public void setFields(T entity){
         Method[] methods = entity.getClass().getDeclaredMethods();
         for (Method method : methods) {

         }
    }
    @Override
    public void delete(ID id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T find(ID id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(T entity) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T insert(T data, String... columnNames) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> selectAll(String... columnNames) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
