package com.ism.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.core.repository.Repository;

public class RepositoryJpaImpl<T> implements Repository<T> {

    protected EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MYSQLDETTES");

    public RepositoryJpaImpl() {
        if (em == null) {
            em = emf.createEntityManager();
        }

    }

    @Override
    public void insert(T data) {
        em.persist(data);
    }

    @Override
    public List<T> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

}
