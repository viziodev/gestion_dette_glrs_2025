package com.ism.repository;

import com.ism.core.repository.Repository;
import com.ism.entities.Client;

public interface ClientRepository  extends Repository<Client>{
    Client selectByTelephone(String telephone)  throws Exception;
    Client selectBySurname(String surname)  throws Exception;
}
