package com.ism.core.factory;

import com.ism.repository.ClientRepository;
import com.ism.repository.UserRepository;
import com.ism.repository.bd.ClientRepositoryBD;
import com.ism.repository.list.UserRepositoryList;

public class Factory {
    private Factory() {

    }
    private static ClientRepository clientRepository;
    private static UserRepository userRepository = null;

    public static ClientRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryBD();
        }
        return clientRepository;
    }
    public static UserRepository getInstanceUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryList();
        }
        return userRepository;
    }

}
