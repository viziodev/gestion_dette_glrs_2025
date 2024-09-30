package com.ism.data.repository.em;

import javax.persistence.NoResultException;

import com.ism.core.repository.impl.RepositoryEmImpl;
import com.ism.data.entities.Client;
import com.ism.data.repository.ClientRepository;

public class ClientRepositoryEm extends RepositoryEmImpl<Client> implements ClientRepository {
   

    public ClientRepositoryEm() {
        super(Client.class);
    
    }

    @Override
    public Client selectByTelephone(String telephone) {
        return em.createNamedQuery("findByTelephone", Client.class)
                .setParameter("telephone", telephone)
                .getSingleResult();
    }

    @Override
    public Client selectBySurname(String surname) {
        try {
            return em.createNamedQuery("findBySurname", Client.class)
                    .setParameter("surname", surname)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
