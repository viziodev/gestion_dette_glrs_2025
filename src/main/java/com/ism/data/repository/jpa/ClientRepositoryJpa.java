package com.ism.data.repository.jpa;

import com.ism.core.repository.impl.RepositoryJpaImpl;
import com.ism.data.entities.Client;
import com.ism.data.repository.ClientRepository;

public class ClientRepositoryJpa extends RepositoryJpaImpl<Client> implements ClientRepository {

    public ClientRepositoryJpa() {
        super(Client.class);
    }

    @Override
    public Client selectByTelephone(String telephone) {
        return this.em.createQuery("SELECT u FROM  Client u where u.telephone like :tel", Client.class)
                .setParameter("tel", telephone)
                .getSingleResult();
    }

    @Override
    public Client selectBySurname(String surname) {
        return this.em.createQuery("SELECT u FROM  Client u where u.telephone like :name", Client.class)
                .setParameter("name", surname)
                .getSingleResult();
    }

}
