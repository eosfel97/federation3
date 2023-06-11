package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Billet;
import com.greta.federation.entity.Rencontre;
import com.greta.federation.entity.Place;
import com.greta.federation.entity.User;
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
    private Rencontre rencontre;
    @JsonIgnore
    private Place place;
    @JsonIgnore
    private User user;

    public static BilletDto fromEntity(Billet billet) {
        if (billet == null) {
            return null;
        }
        return BilletDto.builder()
                .id(billet.getId())
                .numero(billet.getNumero())
                .dateAchat(billet.getDateAchat())
                .rencontre(billet.getRencontre())
                .place(billet.getPlace())
                .user(billet.getUser())
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
        billet.setRencontre(billetDto.getRencontre());
        billet.setPlace(billetDto.getPlace());
        billet.setUser(billetDto.getUser());

        return billet;
    }
}
