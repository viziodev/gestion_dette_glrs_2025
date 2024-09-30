package com.ism.core.repository.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.core.database.impl.DatabaseImpl;
import com.ism.core.factory.yaml.impl.YamlmplFactory;
import com.ism.core.repository.Repository;
import com.ism.core.services.YamlService;

public class RepositoryEmImpl<T> extends DatabaseImpl implements Repository<T> {

    private Class<T> type;
    protected EntityManager em;
    EntityManagerFactory emf;

    public void getEntityManager() {
        if (em == null) {

            YamlService yamlService = YamlmplFactory.createInstance();
            String persistenceUnit = yamlService.yamlToMap().get("persistence").toString();
            emf = Persistence.createEntityManagerFactory(persistenceUnit);
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

    @Override
    public void remove(Integer id) {
        em.getTransaction().begin();
        em.remove(selectById(id));
        em.getTransaction().commit();
    }

    @Override
    public T selectById(Integer id) {
        System.out.println(id);
        return em.find(type, id);
    }

}
