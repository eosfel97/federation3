package com.greta.federation.validator;

import com.greta.federation.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
    public static List<String> validate(CategorieDto categorieDto) {
        List<String> errors = new ArrayList<>();

        if (categorieDto == null || !StringUtils.hasLength(categorieDto.getNom())) {
            errors.add("Veuillez renseigner le nom de la categorie");
        }
        return errors;
    }
}
