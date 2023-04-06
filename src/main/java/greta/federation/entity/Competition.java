package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "competition")
public class Competition extends  AbstractEntity {

    @Column(name = "nom", unique = true)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_type_competition")
    private TypeCompetition typeCompetition;

    @ManyToOne
    @JoinColumn(name = "id_categorie_football")
    private CategorieFootball categorieFootball;
    @OneToMany(mappedBy = "competition")
    private List<Rencontre> rencontres;
    @OneToMany(mappedBy = "competition")
    private List<Saison> saisons;

}
