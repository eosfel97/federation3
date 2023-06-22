package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Place;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class LigneDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private AileDto aile;

    private List<PlaceDto> places;

    public static LigneDto fromEntity(Ligne ligne) {
        if (ligne == null) {
            return null;
        }

        List<PlaceDto> placesDto = ligne.getPlaces().stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());

        return LigneDto.builder()
                .id(ligne.getId())
                .nom(ligne.getNom())
                .places(placesDto)
                .build();
    }

    public static Ligne toEntity(LigneDto ligneDto) {
        if (ligneDto == null) {
            return null;
        }
        Ligne ligne = new Ligne();
        ligne.setId(ligneDto.getId());
        ligne.setNom(ligneDto.getNom());


        return ligne;
    }
}
