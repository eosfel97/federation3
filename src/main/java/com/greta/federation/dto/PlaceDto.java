package com.greta.federation.dto;

import com.greta.federation.entity.Place;
import com.greta.federation.entity.Stade;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {
    private Integer id;
    private String aile;
    private String ligne;
    private String numLigne;
    private StadeDto stade;

    public static PlaceDto fromEntity(Place place) {
        if (place == null) {
            return null;
        }
        return PlaceDto.builder()
                .id(place.getId())
                .aile(place.getAile())
                .ligne(place.getLigne())
                .numLigne(place.getNumLigne())
                .stade(StadeDto.fromEntity(place.getStade()))
                .build();
    }

    public static Place toEntity(PlaceDto placeDto) {
        if (placeDto == null) {
            return null;
        }
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setAile(placeDto.getAile());
        place.setLigne(placeDto.getLigne());
        place.setNumLigne(placeDto.getNumLigne());
        place.setStade(StadeDto.toEntity(placeDto.getStade()));
        return place;
    }
}
