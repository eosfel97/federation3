package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.CategorieFootball;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategorieFootballDto {
    private Integer id;
    private String nom;
    private Integer nbJoueursMaxEquipe;
    private String nbRemplacantEquipe;
    private Integer nbMinuteRencontre;
    private Short nbMiTempsRencontre;
    @JsonIgnore
    private List<EquipeDto> equipes;
    @JsonIgnore
    private List<CompetitionDto> competitions;

    public static CategorieFootballDto fromEntity(CategorieFootball categorieFootball) {
        if (categorieFootball == null) {
            return null;
            // TODO throw an exception
        }

        return CategorieFootballDto.builder()
                .id(categorieFootball.getId())
                .nom(categorieFootball.getNom())
                .nbJoueursMaxEquipe(categorieFootball.getNbJoueursMaxEquipe())
                .nbRemplacantEquipe(categorieFootball.getNbRemplacantEquipe())
                .nbMinuteRencontre(categorieFootball.getNbMinuteRencontre())
                .nbMiTempsRencontre(categorieFootball.getNbMiTempsRencontre())
                .build();
    }

    public static CategorieFootball toEntity(CategorieFootballDto categorieFootballDto) {
        if (categorieFootballDto == null) {
            return null;
            // TODO throw an exception
        }

        CategorieFootball categorieFootball = new CategorieFootball();
        categorieFootball.setId(categorieFootballDto.getId());
        categorieFootball.setNom(categorieFootballDto.getNom());
        categorieFootball.setNbJoueursMaxEquipe(categorieFootball.getNbJoueursMaxEquipe());
        categorieFootball.setNbRemplacantEquipe(categorieFootball.getNbRemplacantEquipe());
        categorieFootball.setNbMinuteRencontre(categorieFootball.getNbMinuteRencontre());
        categorieFootball.setNbMiTempsRencontre(categorieFootball.getNbMiTempsRencontre());

        return categorieFootball;
    }

}
