package greta.federation.dto;

import greta.federation.entity.Competition;
import greta.federation.entity.Equipe;

import java.util.List;

public class CategorieFootballDto {
    private String nom;
    private Integer nbJoueursMaxEquipe;
    private String nbRemplacantEquipe;
    private Integer nbMinuteRencontre;
    private Short nbMiTempsRencontre;
    private List<EquipeDto> equipes;
    private List<CompetitionDto> competitions;
    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbJoueursMaxEquipe() {
        return nbJoueursMaxEquipe;
    }

    public void setNbJoueursMaxEquipe(Integer nbJoueursMaxEquipe) {
        this.nbJoueursMaxEquipe = nbJoueursMaxEquipe;
    }

    public String getNbRemplacantEquipe() {
        return nbRemplacantEquipe;
    }

    public void setNbRemplacantEquipe(String nbRemplacantEquipe) {
        this.nbRemplacantEquipe = nbRemplacantEquipe;
    }

    public Integer getNbMinuteRencontre() {
        return nbMinuteRencontre;
    }

    public void setNbMinuteRencontre(Integer nbMinuteRencontre) {
        this.nbMinuteRencontre = nbMinuteRencontre;
    }

    public Short getNbMiTempsRencontre() {
        return nbMiTempsRencontre;
    }

    public void setNbMiTempsRencontre(Short nbMiTempsRencontre) {
        this.nbMiTempsRencontre = nbMiTempsRencontre;
    }

    public List<EquipeDto> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<EquipeDto> equipes) {
        this.equipes = equipes;
    }

    public List<CompetitionDto> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<CompetitionDto> competitions) {
        this.competitions = competitions;
    }
}
