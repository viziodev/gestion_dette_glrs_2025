package com.ism.core.repository.impl;


import java.util.ArrayList;
import java.util.List;

import com.ism.core.repository.Repository;


public  class RepositoryListImpl<T>  implements Repository<T> {
     protected List<T> list = new ArrayList<>();
     @Override
    public void insert(T data) {
        list.add(data);
    }
    @Override
    public List<T> selectAll() {
        return list;
    }
    @Override
    public void remove(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    @Override
    public T selectById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }
}
