package com.greta.federation.validator;

import com.greta.federation.dto.ArbitreDto;

import java.util.ArrayList;
import java.util.List;

public class ArbitreValidator {

    public static List<String> validate(ArbitreDto arbitreDto) {
        List<String> errors = new ArrayList<>();

        if (arbitreDto == null) {
            errors.add("Veuillez renseigner les informations de l'arbitre.");
            return errors;
        }

        if (arbitreDto.getNom() == null || arbitreDto.getNom().isEmpty()) {
            errors.add("Veuillez renseigner le nom de l'arbitre.");
        }

        if (arbitreDto.getPrenom() == null || arbitreDto.getPrenom().isEmpty()) {
            errors.add("Veuillez renseigner le prénom de l'arbitre.");
        }

        if (arbitreDto.getCategorieFootball() == null) {
            errors.add("Veuillez renseigner la catégorie de football de l'arbitre.");
        }

        // Ajouter d'autres validations si nécessaire

        return errors;
    }
}
