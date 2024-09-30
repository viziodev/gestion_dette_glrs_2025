package com.ism.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.core.repository.Repository;

public class RepositoryJpaImpl<T> implements Repository<T> {

    protected EntityManager em;
    protected Class<T> type;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MYSQLDETTES");

    public RepositoryJpaImpl(Class<T> type) {
        if (em == null) {
            em = emf.createEntityManager();
        }
        this.type = type;

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
        String sql = String.format("SELECT u FROM  %s u", type.getName());
        return this.em.createQuery(sql, type)
                .getResultList();

    }

    // remove
    // selectBy

}
