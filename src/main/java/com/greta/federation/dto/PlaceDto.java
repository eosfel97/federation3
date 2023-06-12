package com.greta.federation.dto;

import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Place;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {
    private Integer id;
    private int numero;

    private Ligne ligne;

    public static PlaceDto fromEntity(Place place) {
        if (place == null) {
            return null;
        }
        return PlaceDto.builder()
                .id(place.getId())
                .ligne(place.getLigne())
                .numero(place.getNumero())
                .build();
    }

    public static Place toEntity(PlaceDto placeDto) {
        if (placeDto == null) {
            return null;
        }
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setLigne(placeDto.getLigne());
        place.setNumero(placeDto.getNumero());

        return place;
    }
}
