package com.greta.federation.validator;

import com.greta.federation.dto.PlaceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PlaceValidator {

    public static List<String> validate(PlaceDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner l'aile de la place");
            errors.add("Veuillez renseigner la ligne de la place");
            errors.add("Veuillez renseigner le numéro de ligne de la place");
            errors.add("Veuillez renseigner l'ID du stade associé");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getAile())) {
            errors.add("Veuillez renseigner l'aile de la place");
        }
        if (!StringUtils.hasLength(dto.getLigne())) {
            errors.add("Veuillez renseigner la ligne de la place");
        }
        if (!StringUtils.hasLength(dto.getNumLigne())) {
            errors.add("Veuillez renseigner le numéro de ligne de la place");
        }
        if (dto.getStade() == null || dto.getStade().getId() == null) {
            errors.add("Veuillez renseigner l'ID du stade associé à la place");
        }

        return errors;
    }
}
