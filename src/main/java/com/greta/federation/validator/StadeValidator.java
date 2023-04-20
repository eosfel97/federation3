package com.greta.federation.validator;

import com.greta.federation.dto.StadeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StadeValidator {

    public static List<String> validate(StadeDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom du stade");
            errors.add("Veuillez renseigner le nombre de places du stade");
            errors.add("Veuillez renseigner le type de terrain du stade");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du stade");
        }
        if (dto.getNbPlaces() == null) {
            errors.add("Veuillez renseigner le nombre de places du stade");
        }
        if (!StringUtils.hasLength(dto.getTypeTerrain())) {
            errors.add("Veuillez renseigner le type de terrain du stade");
        }

        return errors;
    }
}
