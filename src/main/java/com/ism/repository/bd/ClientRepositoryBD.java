package com.ism.repository.bd;

import com.ism.core.repository.impl.RepositoryBD;
import com.ism.entities.Client;
import com.ism.repository.ClientRepository;
import java.sql.*;
import java.util.List;

public class ClientRepositoryBD extends RepositoryBD<Client, Integer> implements ClientRepository {
    public ClientRepositoryBD() {
        super(Client.class);

    }

    @Override
    public Client selectByTelephone(String telephone) throws Exception {
        String query = "select * from client where telephone = ? ";
        ResultSet rs = this.executeQuery(query, telephone);
        if (rs.next()) {
            return this.relationToObject(rs);
        }
        return null;
    }

    @Override
    public Client selectBySurname(String surname) throws Exception {
        String query = "select * from client where surname = ? ";
        ResultSet rs = this.executeQuery(query, surname);
        if (rs.next()) {
            return this.relationToObject(rs, "user");
        }
        return null;
    }

    @Override
    protected String getTableName() {
        return "client";
    }

}
