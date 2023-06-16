package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Billet;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BilletDto {
    private Integer id;
    private String numero;
    private LocalDateTime dateAchat;
    @JsonIgnore
    private RencontreDto rencontre;
    @JsonIgnore
    private PlaceDto place;
    @JsonIgnore
    private UserDto user;

    public static BilletDto fromEntity(Billet billet) {
        if (billet == null) {
            return null;
        }
        return BilletDto.builder()
                .id(billet.getId())
                .numero(billet.getNumero())
                .dateAchat(billet.getDateAchat())
                .rencontre(RencontreDto.fromEntity(billet.getRencontre()))
                .place(PlaceDto.fromEntity(billet.getPlace()))
                .user(UserDto.fromEntity(billet.getUser()))
                .build();
    }

    public static Billet toEntity(BilletDto billetDto) {
        if (billetDto == null) {
            return null;
        }
        Billet billet = new Billet();
        billet.setId(billetDto.getId());
        billet.setNumero(billetDto.getNumero());
        billet.setDateAchat(billetDto.getDateAchat());
        billet.setRencontre(RencontreDto.toEntity(billetDto.getRencontre()));
        billet.setPlace(PlaceDto.toEntity(billetDto.getPlace()));
        billet.setUser(UserDto.toEntity(billetDto.getUser()));

        return billet;
    }
}
