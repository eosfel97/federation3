package com.greta.federation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saison")
public class Saison extends AbstractEntity {

    @Column(name = "annee", nullable = false)
    private Date annee;

    @Column(name = "nb_but")
    private int nbBut;

    @Column(name = "nb_encaisse")
    private int nbEncaisse;

    @Column(name = "meilleur_joueur", length = 50)
    private String meilleurJoueur;

    @Column(name = "meilleur_buteur", length = 50)
    private String meilleurButeur;

    @Column(name = "meilleur_passeur", length = 50)
    private String meilleurPasseur;

    @Column(name = "meilleur_gardien", length = 50)
    private String meilleurGardien;

    @Column(name = "nb_carton_jaune")
    private int nbCartonJaune;

    @Column(name = "nb_carton_rouge")
    private int nbCartonRouge;

    @OneToMany(mappedBy = "saison", cascade=CascadeType.ALL)
    private List<Equipe> equipes;

    @ManyToOne
    @JoinColumn(name = "id_competition")
    private Competition competition;


}