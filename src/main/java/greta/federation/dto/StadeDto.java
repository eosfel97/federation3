package greta.federation.dto;

import greta.federation.entity.Club;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class StadeDto {
    private String nom;
    private Integer nbPlaces;
    private String typeTerrain;
    private List<Club> clubs;
    // G and S

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getTypeTerrain() {
        return typeTerrain;
    }

    public void setTypeTerrain(String typeTerrain) {
        this.typeTerrain = typeTerrain;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
}
