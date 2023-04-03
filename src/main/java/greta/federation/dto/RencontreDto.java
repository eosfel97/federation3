package greta.federation.dto;

import greta.federation.entity.Arbitre;
import greta.federation.entity.Competition;
import greta.federation.entity.Equipe;
import greta.federation.entity.EvenementRencontre;
import java.util.List;

public class RencontreDto {

    private int nbButDomicile;
    private int nbButExterieur;
    private List<ArbitreDto> arbitres;
    private EquipeDto equipeExterieure;
    private EquipeDto equipeDomicile;
    private Competition competition;
    private List<EvenementRencontreDto> evenementRencontres;
    //Getters and Setters

    public int getNbButDomicile() {
        return nbButDomicile;
    }

    public void setNbButDomicile(int nbButDomicile) {
        this.nbButDomicile = nbButDomicile;
    }

    public int getNbButExterieur() {
        return nbButExterieur;
    }

    public void setNbButExterieur(int nbButExterieur) {
        this.nbButExterieur = nbButExterieur;
    }

    public List<ArbitreDto> getArbitres() {
        return arbitres;
    }

    public void setArbitres(List<ArbitreDto> arbitres) {
        this.arbitres = arbitres;
    }

    public EquipeDto getEquipeExterieure() {
        return equipeExterieure;
    }

    public void setEquipeExterieure(EquipeDto equipeExterieure) {
        this.equipeExterieure = equipeExterieure;
    }

    public EquipeDto getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(EquipeDto equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<EvenementRencontreDto> getEvenementRencontres() {
        return evenementRencontres;
    }

    public void setEvenementRencontres(List<EvenementRencontreDto> evenementRencontres) {
        this.evenementRencontres = evenementRencontres;
    }
}
