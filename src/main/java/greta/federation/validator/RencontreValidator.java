package greta.federation.validator;

import greta.federation.dto.RencontreDto;
import java.util.ArrayList;
import java.util.List;

public class RencontreValidator {

    public static List<String> validate(RencontreDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nombre de buts à domicile");
            errors.add("Veuillez renseigner le nombre de buts à l'extérieur");
            errors.add("Veuillez renseigner la compétition");
            return errors;
        }

        if (dto.getNbButDomicile() < 0) {
            errors.add("Le nombre de buts à domicile ne peut pas être négatif");
        }

        if (dto.getNbButExterieur() < 0) {
            errors.add("Le nombre de buts à l'extérieur ne peut pas être négatif");
        }

        if (dto.getCompetition() == null) {
            errors.add("Veuillez renseigner la compétition");
        }

        return errors;
    }
}
