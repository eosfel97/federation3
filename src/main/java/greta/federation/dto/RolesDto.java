package greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private UserDto user;

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .nom(roles.getNom())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setNom(rolesDto.getNom());
        roles.setUser(UserDto.toEntity(rolesDto.getUser()));
        return roles;
    }
}
