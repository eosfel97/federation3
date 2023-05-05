package com.greta.federation.validator;

import com.greta.federation.dto.EquipeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EquipeValidator {

    public static List<String> validate(EquipeDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'équipe");
            errors.add("Veuillez renseigner la catégorie de football de l'équipe");
            errors.add("Veuillez renseigner la saison de l'équipe");
            errors.add("Veuillez renseigner le club de l'équipe");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'équipe");
        }
        if (dto.getCategorieFootball() == null || dto.getCategorieFootball().getId() == null) {
            errors.add("Veuillez renseigner la catégorie de football de l'équipe");
        }
        if (dto.getSaison() == null || dto.getSaison().getId() == null) {
            errors.add("Veuillez renseigner la saison de l'équipe");
        }
        if (dto.getClub() == null || dto.getClub().getId() == null) {
            errors.add("Veuillez renseigner le club de l'équipe");
        }
        return errors;
    }
}
