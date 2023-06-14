package com.greta.federation.dto;

import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Place;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PlaceDto {
    private Integer id;
    private String nom;
    private BigDecimal prix;

    private Ligne ligne;

    public static PlaceDto fromEntity(Place place) {
        if (place == null) {
            return null;
        }
        return PlaceDto.builder()
                .id(place.getId())
                .ligne(place.getLigne())
                .nom(place.getNom())
                .prix(place.getPrix())
                .build();
    }

    public static Place toEntity(PlaceDto placeDto) {
        if (placeDto == null) {
            return null;
        }
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setLigne(placeDto.getLigne());
        place.setPrix(placeDto.getPrix());
        place.setNom(placeDto.getNom());

        return place;
    }
}
