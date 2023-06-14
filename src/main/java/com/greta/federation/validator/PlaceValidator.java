package com.greta.federation.validator;

import com.greta.federation.dto.PlaceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PlaceValidator {
    public static List<String> validate(PlaceDto placeDto) {
        List<String> erreurs = new ArrayList<>();

        if (placeDto.getId() == null){
            erreurs.add("L'id de la place est nécessaire.");
        }

        if (placeDto.getNumero() < 0){
            erreurs.add("Le numéro de la place ne peut pas être négatif.");
        }

        if (placeDto.getLigne() == null){
            erreurs.add("La ligne associée à la place est nécessaire.");
        }
        if (placeDto.getPrix() == null ){
            erreurs.add("vous devez entrer un prix pour la place");
        }
        return erreurs;
    }
}
