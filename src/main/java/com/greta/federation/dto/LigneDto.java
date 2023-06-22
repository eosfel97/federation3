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
    private AileDto aile;
    @JsonIgnore
    private List<PlaceDto> places;

    public static LigneDto fromEntity(Ligne ligne) {
        if (ligne == null) {
            return null;
        }

        return LigneDto.builder()
                .id(ligne.getId())
                .nom(ligne.getNom())
                .aile(AileDto.fromEntity(ligne.getAile()))
                .build();
    }

    public static Ligne toEntity(LigneDto ligneDto) {
        if (ligneDto == null) {
            return null;
        }
        Ligne ligne = new Ligne();
        ligne.setId(ligneDto.getId());
        ligne.setNom(ligneDto.getNom());
        ligne.setAile(AileDto.toEntity(ligneDto.getAile()));

        return ligne;
    }
}
