package com.greta.federation.validator;

import com.greta.federation.dto.EvenementRencontreDto;

import java.util.ArrayList;
import java.util.List;

public class EvenementRencontreValidator {

    public static List<String> validate(EvenementRencontreDto evenementRencontreDto) {
        List<String> errors = new ArrayList<>();

        if (evenementRencontreDto == null) {
            errors.add("EvenementRencontreDto cannot be null.");
            return errors;
        }

        if (evenementRencontreDto.getNom() == null || evenementRencontreDto.getNom().isEmpty()) {
            errors.add("Nom in EvenementRencontreDto cannot be null or empty.");
        }

        if (evenementRencontreDto.getType() == null || evenementRencontreDto.getType().isEmpty()) {
            errors.add("Type in EvenementRencontreDto cannot be null or empty.");
        }

        if (evenementRencontreDto.getJoueur() == null) {
            errors.add("Joueur in EvenementRencontreDto cannot be null.");
        }

        if (evenementRencontreDto.getRencontre() == null) {
            errors.add("Rencontre in EvenementRencontreDto cannot be null.");
        }

        return errors;
    }
}
