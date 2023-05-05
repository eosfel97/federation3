package com.greta.federation.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Poste;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PosteDto {
    private Integer id;

    private String nom;
    @JsonIgnore
    private List<JoueurDto> joueurs;
    public static PosteDto fromEntity(Poste poste) {
        if (poste == null) {
            return null;
        }
        return PosteDto.builder()
                .id(poste.getId())
                .nom(poste.getNom())
                .build();
    }
    public static Poste toEntity(PosteDto posteDto) {
        if (posteDto == null) {
            return null;
        }
        Poste poste = new Poste();

        poste.setId(posteDto.getId());
        poste.setNom(posteDto.getNom());

        return poste;
    }


}
