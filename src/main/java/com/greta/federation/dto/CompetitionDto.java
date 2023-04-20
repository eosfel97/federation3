package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Competition;
import com.greta.federation.entity.Saison;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CompetitionDto {
    private Integer id;
    private String nom;
    private TypeCompetitionDto typeCompetition;
    private CategorieFootballDto categorieFootball;
    @JsonIgnore
    private List<RencontreDto> rencontres;
    @JsonIgnore
    private List<Saison> saisons;

    public static CompetitionDto fromEntity(Competition competition) {
        if (competition == null) {
            return null;
        }
        return CompetitionDto.builder()
                .id(competition.getId())
                .nom(competition.getNom())
                .typeCompetition(TypeCompetitionDto.fromEntity(competition.getTypeCompetition()))
                .categorieFootball(CategorieFootballDto.fromEntity(competition.getCategorieFootball()))
                .build();
    }

    public static Competition toEntity(CompetitionDto competitionDto) {
        if (competitionDto == null) {
            return null;
        }
        Competition competition = new Competition();
        competition.setId(competitionDto.getId());
        competition.setNom(competitionDto.getNom());
        competition.setTypeCompetition(TypeCompetitionDto.toEntity(competitionDto.getTypeCompetition()));
        competition.setCategorieFootball(CategorieFootballDto.toEntity(competitionDto.getCategorieFootball()));
        return competition;
    }

}
