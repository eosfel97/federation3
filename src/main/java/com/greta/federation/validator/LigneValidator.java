package com.greta.federation.validator;

import com.greta.federation.dto.LigneDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneValidator {

    public static List<String> validate(LigneDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de la ligne");
            errors.add("Veuillez sélectionner une aile");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de la ligne");
        }
        if (dto.getAile() == null) {
            errors.add("Veuillez sélectionner une aile");
        }

        return errors;
    }
}
