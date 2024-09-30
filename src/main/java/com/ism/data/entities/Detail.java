package com.ism.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Annotation
@Setter
@ToString
@Entity
@Table(name = "details")
public class Detail extends AbstractEntity {
    private Integer qteStock;
    private Double prix;
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dette dette;
}
