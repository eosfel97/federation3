package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Stade;
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
    private Stade stade;
    private List<LigneDto> lignes;

    public static AileDto fromEntity(Aile aile) {
        if (aile == null) {
            return null;
        }
        List<LigneDto> ligneDtos = aile.getLignes().stream()
                .map(LigneDto::fromEntity)
                .collect(Collectors.toList());
        return AileDto.builder()
                .id(aile.getId())
                .nom(aile.getNom())
                .stade(aile.getStade())
                .lignes(ligneDtos)
                .build();
    }

    public static Aile toEntity(AileDto aileDto) {
        if (aileDto == null) {
            return null;
        }
        Aile aile = new Aile();
        aile.setId(aileDto.getId());
        aile.setNom(aileDto.getNom());
        aile.setStade(aileDto.getStade());
        List<Ligne> lignes = aileDto.getLignes().stream()
                .map(LigneDto::toEntity)
                .collect(Collectors.toList());

        aile.setLignes(lignes);
        return aile;
    }
}
