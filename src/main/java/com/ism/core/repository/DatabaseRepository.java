package com.ism.core.repository;

public interface DatabaseRepository<T,ID> extends Repository<T> {
    T find(ID id) throws Exception;
    void update(T entity) throws Exception;
    void delete(ID id) throws Exception;
}
