package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Stade;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AileDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private Stade stade;

    public static AileDto fromEntity(Aile aile) {
        if (aile == null) {
            return null;
        }
        return AileDto.builder()
                .id(aile.getId())
                .nom(aile.getNom())
                .stade(aile.getStade())
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

        return aile;
    }
}
