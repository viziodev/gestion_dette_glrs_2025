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
        try {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public List<T> selectAll() {
     
       // return this.em.createQuery("SELECT u FROM  Client u", type,)
                //.getResultList();
                return null;

    }

}
