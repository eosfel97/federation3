package com.greta.federation.dto;

import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Ligne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneDto {
    private Integer id;
    private String nom;
    private Aile aile;

    public static LigneDto fromEntity(Ligne ligne) {
        if (ligne == null) {
            return null;
        }
        return LigneDto.builder()
                .id(ligne.getId())
                .nom(ligne.getNom())
                .aile(ligne.getAile())
                .build();
    }

    public static Ligne toEntity(LigneDto ligneDto) {
        if (ligneDto == null) {
            return null;
        }
        Ligne ligne = new Ligne();
        ligne.setId(ligneDto.getId());
        ligne.setNom(ligneDto.getNom());
        ligne.setAile(ligneDto.getAile());

        return ligne;
    }
}
