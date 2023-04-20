package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Equipe;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EquipeDto {
    private Integer id;
    private String nom;
    private int nbJoueurs;
    private String meilleurButeur;
    private String meilleurPasseur;
    private int nbPointSaison;
    @JsonIgnore
    private List<UserDto> users;
    @JsonIgnore
    private List<JoueurDto> joueurs;
    private SaisonDto saison;
    private CategorieFootballDto categorieFootball;
    private ClubDto club;


    public static EquipeDto fromEntity(Equipe equipe) {
        if (equipe == null) {
            return null;
        }
        return EquipeDto.builder()
                .id(equipe.getId())
                .nom(equipe.getNom())
                .nbJoueurs(equipe.getNbJoueurs())
                .meilleurButeur(equipe.getMeilleurButeur())
                .meilleurPasseur(equipe.getMeilleurPasseur())
                .nbPointSaison(equipe.getNbPointSaison())
                .categorieFootball(CategorieFootballDto.fromEntity(equipe.getCategorieFootball()))
                .saison(SaisonDto.fromEntity(equipe.getSaison()))
                .club(ClubDto.fromEntity(equipe.getClub()))
                .build();
    }

    public static Equipe toEntity(EquipeDto equipeDto) {
        if (equipeDto == null) {
            return null;
        }
        Equipe equipe = new Equipe();
        equipe.setId(equipeDto.getId());
        equipe.setNom(equipeDto.getNom());
        equipe.setNbJoueurs(equipeDto.getNbJoueurs());
        equipe.setMeilleurButeur(equipeDto.getMeilleurButeur());
        equipe.setMeilleurPasseur(equipeDto.getMeilleurPasseur());
        equipe.setNbPointSaison(equipeDto.getNbPointSaison());
        equipe.setCategorieFootball(CategorieFootballDto.toEntity(equipeDto.getCategorieFootball()));
        equipe.setSaison(SaisonDto.toEntity(equipeDto.getSaison()));
        equipe.setClub(ClubDto.toEntity(equipeDto.getClub()));
        return equipe;
    }

}
