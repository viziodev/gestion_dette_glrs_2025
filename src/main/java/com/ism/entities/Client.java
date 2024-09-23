package com.ism.entities;

import com.ism.core.repository.AbstractEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Annotation
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Client extends AbstractEntity {
    private int id;
    private String surname;
    private String telephone;
    private String adresse;
    // Navigabilite
    private User user;
}
