package greta.federation.validator;

import greta.federation.dto.ClubDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClubValidator {

    public static List<String> validate(ClubDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom du club");
            errors.add("Veuillez renseigner la date de création du club");
            errors.add("Veuillez renseigner le nom de l'établissement de l'État");
            errors.add("Veuillez renseigner le nom de l'assurance");
            errors.add("Veuillez renseigner le RIB");
            errors.add("Veuillez renseigner l'attestation d'assurance");
            errors.add("Veuillez renseigner l'utilisateur responsable du club");
            errors.add("Veuillez renseigner le stade du club");
            errors.add("Veuillez renseigner l'adresse du club");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du club");
        }

        if (dto.getDateCreation() == null) {
            errors.add("Veuillez renseigner la date de création du club");
        }

        if (!StringUtils.hasLength(dto.getNomEtablissementEtat())) {
            errors.add("Veuillez renseigner le nom de l'établissement de l'État");
        }

        if (!StringUtils.hasLength(dto.getNomAssurance())) {
            errors.add("Veuillez renseigner le nom de l'assurance");
        }

        if (!StringUtils.hasLength(dto.getRib())) {
            errors.add("Veuillez renseigner le RIB");
        }

        if (!StringUtils.hasLength(dto.getAttestationAssurance())) {
            errors.add("Veuillez renseigner l'attestation d'assurance");
        }

        if (dto.getUser() == null) {
            errors.add("Veuillez renseigner l'utilisateur responsable du club");
        }

        if (dto.getStade() == null) {
            errors.add("Veuillez renseigner le stade du club");
        }

        if (dto.getAdresse() == null) {
            errors.add("Veuillez renseigner l'adresse du club");
        }

        return errors;
    }
}
