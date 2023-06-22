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

    private StadeDto stade;
    @JsonIgnore
    private List<LigneDto> lignes;

    public static AileDto fromEntity(Aile aile) {
        if (aile == null) {
            return null;
        }

        return AileDto.builder()
                .id(aile.getId())
                .nom(aile.getNom())
                .stade(StadeDto.fromEntity(aile.getStade()))

                .build();
    }

    public static Aile toEntity(AileDto aileDto) {
        if (aileDto == null) {
            return null;
        }

        Aile aile = new Aile();
        aile.setId(aileDto.getId());
        aile.setNom(aileDto.getNom());
        aile.setStade(StadeDto.toEntity(aileDto.getStade()));
        return aile;
    }
}
