package com.ism.core.factory.repository;

import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.UserRepository;

public interface RepositoryFactory {
    
    ClientRepository getInstanceClientRepository();

    UserRepository getInstanceUserRepository();
}
