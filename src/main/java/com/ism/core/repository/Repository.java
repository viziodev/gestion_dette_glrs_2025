package com.ism.core.repository;

import java.util.List;

public interface Repository<T> {
    T insert(T data,String... columnNames) throws Exception;
    List<T> selectAll(String... columnNames) throws Exception;
   
  
    
}
