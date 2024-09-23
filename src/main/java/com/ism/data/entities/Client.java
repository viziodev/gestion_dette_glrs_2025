package com.ism.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Annotation
@Setter
@ToString
@EqualsAndHashCode()
public class Client {
    private int id;
    private String surname;
    private String telephone;
    private String adresse;

    // Navigabilite
    private User user;
}
