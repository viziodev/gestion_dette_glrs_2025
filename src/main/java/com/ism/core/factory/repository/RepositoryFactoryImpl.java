package com.ism.core.factory.repository;

import com.ism.core.factory.yaml.impl.YamlmplFactory;
import com.ism.core.services.YamlService;
import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.UserRepository;
import com.ism.data.repository.em.ClientRepositoryEm;
import com.ism.data.repository.em.UserRepositoryEm;

public class RepositoryFactoryImpl implements RepositoryFactory {
    private ClientRepository clientRepository = null;
    private UserRepository userRepository = null;

    private RepositoryFactoryImpl() {
    }

    @Override
    public ClientRepository getInstanceClientRepository() {
        YamlService yamlService = YamlmplFactory.createInstance();
        System.out.println("xxxxxxxxxxxx" + yamlService.yamlToMap().get("repository"));
        if (clientRepository == null) {

            clientRepository = new ClientRepositoryEm();
        }
        return clientRepository;
    }

    @Override
    public UserRepository getInstanceUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryEm();
        }
        return userRepository;
    }

    public static RepositoryFactoryImpl getInstance() {
        return new RepositoryFactoryImpl();
    }

}
