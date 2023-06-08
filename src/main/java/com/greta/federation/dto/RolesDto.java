package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.greta.federation.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesDto {
    private Integer id;
    private String nom;
    private List<UserDto> users;

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        List<UserDto> usersDto = roles.getUsers().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());

        return RolesDto.builder()
                .id(roles.getId())
                .nom(roles.getNom())
                .users(usersDto)
                .build();
    }

    @JsonCreator
    public static RolesDto fromString(String nom) {
        return RolesDto.builder()
                .nom(nom)
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setNom(rolesDto.getNom());
        return roles;
    }
}
