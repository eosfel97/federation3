package greta.federation.dto;

import greta.federation.entity.Equipe;
import greta.federation.entity.Stade;
import greta.federation.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class ClubDto {
    private String nom;
    private int numeroRue;
    private String nomRue;
    private String ville;
    private int codePostal;
    private Date dateCreation;
    private String nomEtablissementEtat;
    private String nomAssurance;
    private String rib;
    private String attestationAssurance;
    private User user;
    private List<Equipe> equipes;
    private Stade stade;

    // g and S

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNomEtablissementEtat() {
        return nomEtablissementEtat;
    }

    public void setNomEtablissementEtat(String nomEtablissementEtat) {
        this.nomEtablissementEtat = nomEtablissementEtat;
    }

    public String getNomAssurance() {
        return nomAssurance;
    }

    public void setNomAssurance(String nomAssurance) {
        this.nomAssurance = nomAssurance;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getAttestationAssurance() {
        return attestationAssurance;
    }

    public void setAttestationAssurance(String attestationAssurance) {
        this.attestationAssurance = attestationAssurance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }
}
