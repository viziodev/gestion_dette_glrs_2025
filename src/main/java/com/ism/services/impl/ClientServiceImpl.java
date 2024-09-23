package com.ism.services.impl;

import java.util.List;

import com.ism.entities.Client;

import com.ism.repository.ClientRepository;
import com.ism.repository.UserRepository;
import com.ism.services.ClientService;
import java.util.Collections;

public class ClientServiceImpl implements ClientService {
    // Couplage Faible entre le Servic et le Repository
    private ClientRepository clientRepository;
    private UserRepository userRepository;

    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Client createClient(Client client) {

        try {
            clientRepository.insert(client, "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> findAllClient() {
        try {
            return clientRepository.selectAll("user");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Client searchClient(String telephone) {
        try {
            return clientRepository.selectByTelephone(telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client searchClientBySurname(String surname) {
        try {
            return clientRepository.selectBySurname(surname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
