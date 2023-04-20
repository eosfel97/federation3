package com.greta.federation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "joueur")
public class Joueur extends AbstractEntity{


    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "poids")
    private String poids;

    @Column(name = "taille")
    private String taille;

    @Column(name = "nb_but")
    private int nbBut;

    @Column(name = "nb_passe_decisive")
    private int nbPasseDecisive;

    @Column(name = "nb_carton_jaune")
    private int nbCartonJaune;

    @Column(name = "nb_carton_rouge")
    private int nbCartonRouge;

    @Column(name = "nb_but_encaisse")
    private int nbButEncaisse;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "id_evenement_rencontre")
    private EvenementRencontre evenementRencontre;

}
