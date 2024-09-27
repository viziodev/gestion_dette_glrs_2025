package com.ism.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Getter // Annotation
@Setter
@ToString(of = { "id", "surname", "telephone", "adresse" })
@EqualsAndHashCode()
@Entity
@Table(name = "clients")
@NamedQueries({
        @NamedQuery(name = "findBySurname", query = "select p from Client p where p.surname like :surname")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String surname;
    @Column(unique = true)
    private String telephone;
    private String adresse;

    // Navigabilite
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private User user;

}
