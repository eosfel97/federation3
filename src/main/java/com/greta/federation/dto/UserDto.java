package com.greta.federation.dto;

import antlr.ANTLRParser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.greta.federation.entity.Roles;
import com.greta.federation.entity.User;
import lombok.Builder;
import lombok.Data;


import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String portable;
    private String identifiant;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private AdresseDto adresse;

    private RolesDto role;

    @JsonIgnore
    private List<CommandeDto> commandes;
    private EquipeDto equipe;


    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .portable(user.getPortable())
                .email(user.getEmail())
                .identifiant(user.getIdentifiant())
                .password(user.getPassword())
                .adresse(AdresseDto.fromEntity(user.getAdresse()))
                .equipe(EquipeDto.fromEntity(user.getEquipe()))
                .build();

        userDto.setRoleFromEntity(user.getRole());

        return userDto;
    }

    public void setRoleFromEntity(Roles role) {
        if (role != null) {
            RolesDto roleDto = new RolesDto();
            roleDto.setId(role.getId());
            this.role = roleDto;
        }
    }



    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setPortable(userDto.getPortable());
        user.setIdentifiant(userDto.getIdentifiant());
        user.setPassword(userDto.getPassword());
        user.setAdresse(AdresseDto.toEntity(userDto.getAdresse()));
        user.setEquipe(EquipeDto.toEntity(userDto.getEquipe()));
        user.setRole(RolesDto.toEntity(userDto.getRole()));

        if (userDto.getCommandes() != null) {
            user.setCommandes(userDto.getCommandes().stream()
                    .map(CommandeDto::toEntity)
                    .collect(Collectors.toList()));
        }

        return user;
    }

}
