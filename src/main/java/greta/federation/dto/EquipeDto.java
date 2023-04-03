package greta.federation.dto;

import greta.federation.entity.*;

import java.util.List;

public class EquipeDto {
    private String nom;
    private int nbJoueurs;
    private String meilleurButeur;
    private String meilleurPasseur;
    private int nbPointSaison;
    private List<UserDto> users;
    private List<JoueurDto> joueurs;
    private SaisonDto saison;
    private CategorieFootballDto categorieFootball;
    private ClubDto club;
    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public String getMeilleurButeur() {
        return meilleurButeur;
    }

    public void setMeilleurButeur(String meilleurButeur) {
        this.meilleurButeur = meilleurButeur;
    }

    public String getMeilleurPasseur() {
        return meilleurPasseur;
    }

    public void setMeilleurPasseur(String meilleurPasseur) {
        this.meilleurPasseur = meilleurPasseur;
    }

    public int getNbPointSaison() {
        return nbPointSaison;
    }

    public void setNbPointSaison(int nbPointSaison) {
        this.nbPointSaison = nbPointSaison;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<JoueurDto> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<JoueurDto> joueurs) {
        this.joueurs = joueurs;
    }

    public SaisonDto getSaison() {
        return saison;
    }

    public void setSaison(SaisonDto saison) {
        this.saison = saison;
    }

    public CategorieFootballDto getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootballDto categorieFootball) {
        this.categorieFootball = categorieFootball;
    }

    public ClubDto getClub() {
        return club;
    }

    public void setClub(ClubDto club) {
        this.club = club;
    }
}
