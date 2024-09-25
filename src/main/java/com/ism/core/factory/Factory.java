package com.ism.core.factory;

import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.UserRepository;
import com.ism.data.repository.em.ClientRepositoryEm;
import com.ism.data.repository.em.UserRepositoryEm;


public class Factory {
    private Factory() {

    }

    private static ClientRepository clientRepository = null;
    private static UserRepository userRepository = null;

    public static ClientRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryEm(getInstanceUserRepository());
        }
        return clientRepository;
    }

    public static UserRepository getInstanceUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryEm();
        }
        return userRepository;
    }

}
