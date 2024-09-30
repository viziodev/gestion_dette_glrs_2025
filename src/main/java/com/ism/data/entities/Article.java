package com.ism.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Getter // Annotation
@Setter
@ToString
@EqualsAndHashCode()
@Entity
@Table(name = "articles")
public class Article {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;
      private String libelle;
      private String reference;
      private int qteStock;
      private double prix;

      @ManyToMany(mappedBy = "article")
      private List<Detail> details;

}
