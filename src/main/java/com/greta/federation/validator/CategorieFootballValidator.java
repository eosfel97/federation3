package com.greta.federation.validator;

import com.greta.federation.dto.CategorieFootballDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieFootballValidator {

    public static List<String> validate(CategorieFootballDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de la catégorie de football");
            errors.add("Veuillez renseigner le nombre de joueurs maximum par équipe");
            errors.add("Veuillez renseigner le nombre de remplaçants par équipe");
            errors.add("Veuillez renseigner la durée en minutes d'une rencontre");
            errors.add("Veuillez renseigner le nombre de mi-temps d'une rencontre");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de la catégorie de football");
        }
        if (dto.getNbJoueursMaxEquipe() == null) {
            errors.add("Veuillez renseigner le nombre de joueurs maximum par équipe");
        }
        if (!StringUtils.hasLength(dto.getNbRemplacantEquipe())) {
            errors.add("Veuillez renseigner le nombre de remplaçants par équipe");
        }
        if (dto.getNbMinuteRencontre() == null) {
            errors.add("Veuillez renseigner la durée en minutes d'une rencontre");
        }
        if (dto.getNbMiTempsRencontre() == null) {
            errors.add("Veuillez renseigner le nombre de mi-temps d'une rencontre");
        }

        return errors;
    }
}
