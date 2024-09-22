package com.ism.core.config;


import java.util.ArrayList;
import java.util.List;


public class RepositoryListImpl<T>  implements Repository<T> {
     protected List<T> list = new ArrayList<>();

 
     @Override
    public void insert(T data) {
        list.add(data);
    }
    @Override
    public List<T> selectAll() {
        return list;
    }
}
