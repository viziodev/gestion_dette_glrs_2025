package com.ism.data.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Annotation
@Setter
@ToString
@EqualsAndHashCode()
@Entity
@Table(name = "dettes")
public class Dette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double montant;
    private Double montantVerser;
    @Transient
    private Double montantRestant;

    @ManyToOne
    private Client client;

    @ManyToMany(mappedBy = "dette")
    private List<Detail> details;
}
