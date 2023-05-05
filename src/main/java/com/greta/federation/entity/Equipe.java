package com.greta.federation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipe")
public class Equipe extends AbstractEntity {


    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_joueurs")
    private int nbJoueurs;

    @Column(name = "meilleur_buteur")
    private String meilleurButeur;

    @Column(name = "meilleur_passeur")
    private String meilleurPasseur;

    @Column(name = "nb_point_saison")
    private int nbPointSaison;

    @OneToMany (mappedBy ="equipe",cascade=CascadeType.ALL)
    private List<User> users;
    @OneToMany (mappedBy ="equipe",cascade=CascadeType.ALL)
    private List<Joueur> joueurs;
    @ManyToOne
    @JoinColumn(name = "id_saison")
    private Saison saison;

    @ManyToOne
    @JoinColumn(name = "id_categorie_football")
    private CategorieFootball categorieFootball;

    @ManyToOne()
    @JoinColumn(name = "id_club")
    private Club club;



}
