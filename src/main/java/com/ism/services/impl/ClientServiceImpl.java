package com.ism.services.impl;

import java.util.List;

import com.ism.core.config.Repository;
import com.ism.entities.Client;
import com.ism.entities.User;
import com.ism.repository.ClientRepository;
import com.ism.repository.UserRepository;
import com.ism.services.ClientService;

public class ClientServiceImpl  implements ClientService{
    //Couplage Faible entre le Servic et le Repository
    private ClientRepository clientRepository;
    private UserRepository userRepository;

    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createClient(Client client) {
        
        clientRepository.insert(client);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.selectAll();
    }

    @Override
    public Client searchClient(String telephone) {
        return clientRepository.selectByTelephone(telephone);
    }

    @Override
    public Client searchClientBySurname(String surname) {
        return clientRepository.selectBySurname(surname);
    }

}
