package com.greta.federation.validator;

import com.greta.federation.dto.AileDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AileValidator {

    public static List<String> validate(AileDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'aile");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'aile");
        }
        if (dto.getStade() == null) {
            errors.add("Veuillez renseigner le stade parent de l'aile");
        }

        return errors;
    }
}
