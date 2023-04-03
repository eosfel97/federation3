package greta.federation.dto;


import java.util.Date;
import java.util.List;

public class SaisonDto {
    private Date annee;
    private int nbBut;
    private int nbEncaisse;
    private String meilleurJoueur;
    private String meilleurButeur;
    private String meilleurPasseur;
    private String meilleurGardien;
    private int nbCartonJaune;
    private int nbCartonRouge;
    private List<EquipeDto> equipes;
    private CompetitionDto competition;
    //Getters and Setters

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getNbBut() {
        return nbBut;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public int getNbEncaisse() {
        return nbEncaisse;
    }

    public void setNbEncaisse(int nbEncaisse) {
        this.nbEncaisse = nbEncaisse;
    }

    public String getMeilleurJoueur() {
        return meilleurJoueur;
    }

    public void setMeilleurJoueur(String meilleurJoueur) {
        this.meilleurJoueur = meilleurJoueur;
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

    public String getMeilleurGardien() {
        return meilleurGardien;
    }

    public void setMeilleurGardien(String meilleurGardien) {
        this.meilleurGardien = meilleurGardien;
    }

    public int getNbCartonJaune() {
        return nbCartonJaune;
    }

    public void setNbCartonJaune(int nbCartonJaune) {
        this.nbCartonJaune = nbCartonJaune;
    }

    public int getNbCartonRouge() {
        return nbCartonRouge;
    }

    public void setNbCartonRouge(int nbCartonRouge) {
        this.nbCartonRouge = nbCartonRouge;
    }

    public List<EquipeDto> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<EquipeDto> equipes) {
        this.equipes = equipes;
    }

    public CompetitionDto getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDto competition) {
        this.competition = competition;
    }
}
