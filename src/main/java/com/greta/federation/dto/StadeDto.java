package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Stade;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class StadeDto {
    private Integer id;
    private String nom;
    private Integer nbPlaces;
    private String typeTerrain;

    private List<AileDto> ailes;
    @JsonIgnore
    private List<ClubDto> clubs;


    public static StadeDto fromEntity(Stade stade) {
        if (stade == null) {
            return null;
        }
        List<AileDto> ailesDto = stade.getAiles().stream()
                .map(AileDto::fromEntity)
                .collect(Collectors.toList());

        return StadeDto.builder()
                .id(stade.getId())
                .nom(stade.getNom())
                .nbPlaces(stade.getNbPlaces())
                .typeTerrain(stade.getTypeTerrain())
                .ailes(ailesDto)
                .build();
    }

    public static Stade toEntity(StadeDto stadeDto) {
        if (stadeDto == null) {
            return null;
        }
        Stade stade = new Stade();

        stade.setId(stadeDto.getId());
        stade.setNom(stadeDto.getNom());
        stade.setNbPlaces(stadeDto.getNbPlaces());
        stade.setTypeTerrain(stadeDto.getTypeTerrain());

        List<Aile> ailes = stadeDto.getAiles().stream()
                .map(AileDto::toEntity)
                .collect(Collectors.toList());

        stade.setAiles(ailes);

        return stade;
    }
}
