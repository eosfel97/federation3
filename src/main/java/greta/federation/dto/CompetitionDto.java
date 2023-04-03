package greta.federation.dto;

import greta.federation.entity.CategorieFootball;
import greta.federation.entity.Rencontre;
import greta.federation.entity.TypeCompetition;
import java.util.List;

public class CompetitionDto {
    private String nom;
    private TypeCompetitionDto typeCompetition;
    private CategorieFootballDto categorieFootball;
    private List<RencontreDto> rencontres;
    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeCompetitionDto getTypeCompetition() {
        return typeCompetition;
    }

    public void setTypeCompetition(TypeCompetitionDto typeCompetition) {
        this.typeCompetition = typeCompetition;
    }

    public CategorieFootballDto getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootballDto categorieFootball) {
        this.categorieFootball = categorieFootball;
    }

    public List<RencontreDto> getRencontres() {
        return rencontres;
    }

    public void setRencontres(List<RencontreDto> rencontres) {
        this.rencontres = rencontres;
    }
}
