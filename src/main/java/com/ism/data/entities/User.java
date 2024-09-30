package com.ism.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.ism.data.enums.RoleEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Getter // Annotation
@Setter
@ToString(exclude = { "client" })
@EqualsAndHashCode(callSuper = false, of = { "login" })
@Entity
@Table(name = "users")
public class User  extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String login;
    private String prenom;
    private String nom;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @ColumnDefault("true")
    private boolean etat;

    // Navigabilite
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private Client client;

}
