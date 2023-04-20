package com.greta.federation.validator;

import com.greta.federation.dto.CompetitionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompetitionValidator {

    public static List<String> validate(CompetitionDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de la compétition");
            errors.add("Veuillez renseigner le type de compétition");
            errors.add("Veuillez renseigner la catégorie de football");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de la compétition");
        }

        if (dto.getTypeCompetition() == null) {
            errors.add("Veuillez renseigner le type de compétition");
        }

        if (dto.getCategorieFootball() == null) {
            errors.add("Veuillez renseigner la catégorie de football");
        }

        return errors;
    }
}