package greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.*;
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
    private String password;
    private AdresseDto adresse;

    private List<RolesDto> roles;
    @JsonIgnore
    private List<CommandeDto> commandes;
    private EquipeDto equipe;

    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .portable(user.getPortable())
                .email(user.getEmail())
                .identifiant(user.getIdentifiant())
                .password(user.getPassword())
                .adresse(AdresseDto.fromEntity(user.getAdresse()))
                .equipe(EquipeDto.fromEntity(user.getEquipe()))
                .roles(
                        user.getRoles() != null ?
                                user.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
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

        return user;
    }

}
