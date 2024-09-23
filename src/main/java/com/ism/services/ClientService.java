package com.ism.services;

import java.util.List;

import com.ism.entities.Client;

public interface ClientService {
    Client createClient(Client client);

    List<Client> findAllClient();

    Client searchClient(String telephone);

    Client searchClientBySurname(String surname);
}
