package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Ligne;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class AileDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private StadeDto stade;

    private List<LigneDto> lignes;

    public static AileDto fromEntity(Aile aile) {
        if (aile == null) {
            return null;
        }

        List<LigneDto> lignesDto = aile.getLignes().stream()
                .map(LigneDto::fromEntity)
                .collect(Collectors.toList());

        return AileDto.builder()
                .id(aile.getId())
                .nom(aile.getNom())
                .lignes(lignesDto)
                .build();
    }

    public static Aile toEntity(AileDto aileDto) {
        if (aileDto == null) {
            return null;
        }

        Aile aile = new Aile();
        aile.setId(aileDto.getId());
        aile.setNom(aileDto.getNom());

        return aile;
    }
}
