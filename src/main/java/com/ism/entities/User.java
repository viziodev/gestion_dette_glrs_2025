package com.ism.entities;

import lombok.Data;

@Data
public class User {
    private String login;
    private String prenom;
    private String nom;
    private String password;

    // Navigabilite
    private Client client;

}
