package com.ism.data.repository;

import com.ism.core.repository.Repository;
import com.ism.data.entities.Client;

public interface ClientRepository  extends Repository<Client>{
    Client selectByTelephone(String telephone);
    Client selectBySurname(String surname);
}
