package com.greta.federation.dto;

import com.greta.federation.entity.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {

    private String nom_rue;

    private int num_rue;

    private String libellee_rue;

    private String ville;

    private  String codePostale;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }

        return AdresseDto.builder()
                .nom_rue(adresse.getNom_rue())
                .num_rue(adresse.getNum_rue())
                .libellee_rue(adresse.getLibellee_rue())
                .codePostale(adresse.getCodePostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Adresse adresse = new Adresse();
                adresse.setNom_rue(adresseDto.getNom_rue());
                adresse.setNum_rue(adresseDto.getNum_rue());
                adresse.setLibellee_rue(adresseDto.getLibellee_rue());
                adresse.setCodePostale(adresseDto.getCodePostale());
                adresse.setVille(adresseDto.getVille());
                adresse.setPays(adresseDto.getPays());
        return adresse;
    }


}
