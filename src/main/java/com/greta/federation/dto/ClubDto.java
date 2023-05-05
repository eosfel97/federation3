package com.greta.federation.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Club;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class ClubDto {
    private Integer id;
    private String nom;
    private Date dateCreation;
    private String nomEtablissementEtat;
    private String nomAssurance;
    private String rib;
    private String attestationAssurance;
    private UserDto user;
    @JsonIgnore
    private List<EquipeDto> equipes;
    private StadeDto stade;
    private AdresseDto adresse;

    public static ClubDto fromEntity(Club club){

        if(club == null) {
            return  null ;
            // TODO throw an exception
        }
        return  ClubDto.builder()
                .id(club.getId())
                .nom(club.getNom())
                .dateCreation(club.getDateCreation())
                .nomEtablissementEtat(club.getNomEtablissementEtat())
                .nomAssurance(club.getNomAssurance())
                .rib(club.getRib())
                .attestationAssurance(club.getAttestationAssurance())
                .user(UserDto.fromEntity(club.getUser()))
                .stade(StadeDto.fromEntity(club.getStade()))
                .adresse(AdresseDto.fromEntity(club.getAdresse()))
                .build();
    }
    public static Club toEntity(ClubDto clubDto) {
        if (clubDto == null) {
            return null;
        }
        Club club = new Club();
        club.setId(clubDto.getId());
        club.setNom(clubDto.getNom());
        club.setDateCreation(clubDto.getDateCreation());
        club.setNomEtablissementEtat(clubDto.getNomEtablissementEtat());
        club.setNomAssurance(clubDto.getNomAssurance());
        club.setRib(clubDto.getRib());
        club.setAttestationAssurance(clubDto.getAttestationAssurance());
        club.setUser(UserDto.toEntity(clubDto.getUser()));
        club.setStade(StadeDto.toEntity(clubDto.getStade()));
        club.setAdresse(AdresseDto.toEntity(clubDto.getAdresse()));
        return club;
    }
}
