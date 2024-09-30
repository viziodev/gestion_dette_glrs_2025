package com.ism.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double prixVente;
    private Integer qteVendu;
    @ManyToOne
    private Article article;
    @ManyToOne
    private Dette dette;
}
