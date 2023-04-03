package greta.federation.dto;

import greta.federation.entity.Adresse;
import greta.federation.entity.Commande;
import greta.federation.entity.Equipe;
import greta.federation.entity.Roles;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

public class UserDto {

    private String nom;
    private String prenom;
    private String email;
    private String portable;
    private String identifiant;
    private String password;
    private AdresseDto adresse;
    private RolesDto roles;
    private List<CommandeDto> commandes;
    private EquipeDto equipe;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public RolesDto getRoles() {
        return roles;
    }

    public void setRoles(RolesDto roles) {
        this.roles = roles;
    }

    public List<CommandeDto> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandeDto> commandes) {
        this.commandes = commandes;
    }

    public EquipeDto getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeDto equipe) {
        this.equipe = equipe;
    }
}
