package com.ism.data.repository.list;


import com.ism.core.repository.impl.RepositoryListImpl;
import com.ism.data.entities.Client;
import com.ism.data.repository.ClientRepository;


public class ClientRepositoryList extends RepositoryListImpl<Client>  implements ClientRepository{
   
    @Override
    public Client selectByTelephone(String telephone) {
        return list.stream()
                .filter(client -> client.getTelephone().compareTo(telephone) == 0)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Client selectBySurname(String surname) {
        return list.stream()
                .filter(client -> client.getSurname().compareTo(surname) == 0)
                .findFirst()
                .orElse(null);

    }
}
