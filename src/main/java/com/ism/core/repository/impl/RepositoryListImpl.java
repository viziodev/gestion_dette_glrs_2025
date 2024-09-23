package com.ism.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.ism.core.repository.Repository;

public class RepositoryListImpl<T> implements Repository<T> {
    protected List<T> list = new ArrayList<>();

    @Override
    public T insert(T data, String... columnNames) {
        list.add(data);
        return data;
    }

    @Override
    public List<T> selectAll(String... columnNames) {
        return list;
    }
}
