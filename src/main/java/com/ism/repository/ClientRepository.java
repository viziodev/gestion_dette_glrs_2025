package com.ism.repository;

import com.ism.core.config.Repository;
import com.ism.entities.Client;

public interface ClientRepository  extends Repository<Client>{
    Client selectByTelephone(String telephone);
    Client selectBySurname(String surname);
}
