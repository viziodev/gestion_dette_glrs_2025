package com.ism.data.repository.em;

import javax.persistence.NoResultException;

import com.ism.core.repository.impl.RepositoryEmImpl;
import com.ism.data.entities.Client;
import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.UserRepository;

public class ClientRepositoryEm extends RepositoryEmImpl<Client> implements ClientRepository {
    UserRepository userRepository;

    public ClientRepositoryEm(UserRepository userRepository) {
        super(Client.class);
        this.userRepository = userRepository;
    }

    @Override
    public Client selectByTelephone(String telephone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByTelephone'");
    }

    @Override
    public Client selectBySurname(String surname) {
        try {
            return em.createNamedQuery("findBySurname", Client.class)
                    .setParameter("surname", surname)
                    .getSingleResult();

            // return em.createQuery("SELECT u FROM Client u WHERE u.surname = :name",
            // Client.class)
            // .setParameter("name", surname)
            // .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
