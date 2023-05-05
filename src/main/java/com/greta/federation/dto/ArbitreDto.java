package com.greta.federation.dto;

import com.greta.federation.entity.Arbitre;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ArbitreDto {
    private Integer id;
    private String nom;
    private String prenom;
    private CategorieFootballDto categorieFootball;
    private RencontreDto rencontre;
    public static ArbitreDto fromEntity(Arbitre arbitre) {
        if (arbitre == null) {
            return null;
            // TODO throw an exception
        }
        return ArbitreDto.builder()
                .id(arbitre.getId())
                .nom(arbitre.getNom())
                .prenom(arbitre.getPrenom())
                .categorieFootball(CategorieFootballDto.fromEntity(arbitre.getCategorieFootball()))
                .rencontre(RencontreDto.fromEntity(arbitre.getRencontre()))
                .build();
    }

    public static Arbitre toEntity(ArbitreDto arbitreDto) {
        if (arbitreDto == null) {
            return null;
            // TODO throw an exception
        }

        Arbitre arbitre = new Arbitre();
        arbitre.setId(arbitreDto.getId());
        arbitre.setNom(arbitreDto.getNom());
        arbitre.setPrenom(arbitreDto.getPrenom());
        arbitre.setCategorieFootball(CategorieFootballDto.toEntity(arbitreDto.getCategorieFootball()));
        arbitre.setRencontre(RencontreDto.toEntity(arbitreDto.getRencontre()));

        return arbitre;
    }


}
