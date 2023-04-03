package greta.federation.dto;

import greta.federation.entity.CategorieFootball;
import greta.federation.entity.Rencontre;



public class ArbitreDto {
    private String nom;
    private String prenom;
    private CategorieFootballDto categorieFootball;
    private RencontreDto rencontre;

    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public CategorieFootballDto getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootballDto categorieFootball) {
        this.categorieFootball = categorieFootball;
    }

    public RencontreDto getRencontre() {
        return rencontre;
    }

    public void setRencontre(RencontreDto rencontre) {
        this.rencontre = rencontre;
    }
}
