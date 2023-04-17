package greta.federation.validator;

import greta.federation.dto.JoueurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class JoueurValidator {
    public static List<String> validate(JoueurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le prénom du joueur");
            errors.add("Veuillez renseigner le nom du joueur");
            errors.add("Veuillez renseigner le poids du joueur");
            errors.add("Veuillez renseigner la taille du joueur");
            errors.add("Veuillez sélectionner un poste");
            errors.add("Veuillez sélectionner une équipe");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez renseigner le prénom du joueur");
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du joueur");
        }

        if (!StringUtils.hasLength(dto.getPoids())) {
            errors.add("Veuillez renseigner le poids du joueur");
        }

        if (!StringUtils.hasLength(dto.getTaille())) {
            errors.add("Veuillez renseigner la taille du joueur");
        }
        if (dto.getPoste() == null) {
            errors.add("Veuillez sélectionner un poste");
        }

        if (dto.getEquipe() == null) {
            errors.add("Veuillez sélectionner une équipe");
        }

        return errors;
    }
}
