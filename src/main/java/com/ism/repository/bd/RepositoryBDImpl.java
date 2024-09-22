package com.ism.repository.bd;

import java.util.List;

import com.ism.core.config.Repository;

public class RepositoryBDImpl<T> implements Repository<T> {

    @Override
    public void insert(T data) {
        System.out.println("Creation dans une BD");
    }

    @Override
    public List<T> selectAll() {
        // sql
        return null;
    }
}
