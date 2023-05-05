package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Rencontre;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class RencontreDto {
    private Integer id;

    private int nbButDomicile;
    private int nbButExterieur;
    @JsonIgnore
    private List<ArbitreDto> arbitres;
    private EquipeDto equipeExterieure;
    private EquipeDto equipeDomicile;
    private CompetitionDto competition;
    @JsonIgnore
    private List<EvenementRencontreDto> evenementRencontres;

    public static RencontreDto fromEntity(Rencontre rencontre) {
        if (rencontre == null) {
            return null;
        }
        return RencontreDto.builder()
                .id(rencontre.getId())
                .nbButDomicile(rencontre.getNbButDomicile())
                .nbButExterieur(rencontre.getNbButExterieur())
                .competition(CompetitionDto.fromEntity(rencontre.getCompetition()))
                .build();
    }

    public static Rencontre toEntity(RencontreDto rencontreDto) {
        if (rencontreDto == null) {
            return null;
        }
        Rencontre rencontre = new Rencontre();
        rencontre.setId(rencontreDto.getId());
        rencontre.setNbButDomicile(rencontreDto.getNbButDomicile());
        rencontre.setNbButExterieur(rencontreDto.getNbButExterieur());
        rencontre.setCompetition(CompetitionDto.toEntity(rencontreDto.getCompetition()));

        return rencontre;
    }


}
