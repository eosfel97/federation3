package greta.federation.validator;

import greta.federation.dto.ActualiteDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ActualiteValidator {
    public static List<String> validate(ActualiteDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le titre de l'actualite");
            errors.add("Veuillez renseigner l' information de l'actualite");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getTitre())) {
            errors.add("Veuillez renseigner le titre de l'actualite");
        }
        if (!StringUtils.hasLength(dto.getInformation())) {
            errors.add("Veuillez renseigner l' information de l'actualite");
        }

        return errors;
    }
}
