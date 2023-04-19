package greta.federation.validator;

import greta.federation.dto.TypeCompetitionDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class TypeCompetitionValidator {

    public static List<String> validate(TypeCompetitionDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du type de compétition");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du type de compétition");
        }

        return errors;
    }
}