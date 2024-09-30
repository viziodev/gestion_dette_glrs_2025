package com.ism.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Getter // Annotation
@Setter
@ToString(exclude = { "user", "dettes" })
@EqualsAndHashCode(callSuper = false, of = { "surname" })
@Entity
@Table(name = "clients")
@NamedQueries({
        @NamedQuery(name = "findBySurname", query = "select p from Client p where p.surname like :surname"),
        @NamedQuery(name = "findByTelephone", query = "select p from Client p where p.telephone like :telephone")
})
public class Client extends AbstractEntity {
    @Column(unique = true)
    private String surname;
    @Column(unique = true)
    private String telephone;
    private String adresse;

    // Navigabilite
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private User user;

    @OneToMany(mappedBy = "client")
    List<Dette> dettes;

}
