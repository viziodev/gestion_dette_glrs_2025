package com.ism.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter // Annotation
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "dettes")
@Entity
public class Dette extends AbstractEntity {
    private Double montant;
    private Double montanVerser;
    @Transient
    private Double montantRestant;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "dette")
    List<Detail> details;
}
