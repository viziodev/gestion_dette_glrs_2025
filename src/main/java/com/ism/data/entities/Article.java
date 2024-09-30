package com.ism.data.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter // Annotation
@Setter
@ToString(exclude = { "dettes" })
@EqualsAndHashCode(callSuper = false, of = { "reference" })
@Entity
@Table(name = "articles")
public class Article extends AbstractEntity {
      private String libelle;
      private String reference;
      private Integer qteStock;
      private Double prix;
      @OneToMany(mappedBy = "article")
      List<Detail> details;
}
