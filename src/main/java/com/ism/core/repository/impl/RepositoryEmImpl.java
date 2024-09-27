package com.ism.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.core.database.impl.DatabaseImpl;
import com.ism.core.repository.Repository;

public class RepositoryEmImpl<T> extends DatabaseImpl implements Repository<T> {

    private Class<T> type;
    protected EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DETTES");

    public void getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    public RepositoryEmImpl(Class<T> type) {
        getEntityManager();
        this.type = type;

    }

    @Override
    public void insert(T data) {
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();
    }

    @Override
    public List<T> selectAll() {
        String query = String.format("SELECT u FROM  %s u", type.getName());
        return this.em.createQuery(query, type)
                .getResultList();
    }

}
