package com.greta.federation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categorie")
public class Categorie extends AbstractEntity {


    @Column(name="nom")
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

}