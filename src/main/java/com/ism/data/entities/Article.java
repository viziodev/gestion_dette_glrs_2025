package com.ism.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Annotation
@Setter
@ToString
@EqualsAndHashCode()
public class Article {
      private String libelle;
      private String reference;
      private int qteStock;
      private double prix;
    
}
