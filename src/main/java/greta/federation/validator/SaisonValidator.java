package greta.federation.validator;

import greta.federation.dto.SaisonDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaisonValidator {

    public static List<String> validate(SaisonDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner les informations de la saison");
            return errors;
        }
        if (dto.getAnnee() == null) {
            errors.add("Veuillez renseigner l'année de la saison");
        }
        if (dto.getCompetition() == null) {
            errors.add("Veuillez renseigner la compétition de la saison");
        }
        if (dto.getNbBut() < 0) {
            errors.add("Le nombre de buts ne peut pas être négatif");
        }
        if (dto.getNbEncaisse() < 0) {
            errors.add("Le nombre de buts encaissés ne peut pas être négatif");
        }
        if (dto.getNbCartonJaune() < 0) {
            errors.add("Le nombre de cartons jaunes ne peut pas être négatif");
        }
        if (dto.getNbCartonRouge() < 0) {
            errors.add("Le nombre de cartons rouges ne peut pas être négatif");
        }
        if (!StringUtils.hasLength(dto.getMeilleurJoueur())) {
            errors.add("Veuillez renseigner le meilleur joueur de la saison");
        }
        if (!StringUtils.hasLength(dto.getMeilleurButeur())) {
            errors.add("Veuillez renseigner le meilleur buteur de la saison");
        }
        if (!StringUtils.hasLength(dto.getMeilleurPasseur())) {
            errors.add("Veuillez renseigner le meilleur passeur de la saison");
        }
        if (!StringUtils.hasLength(dto.getMeilleurGardien())) {
            errors.add("Veuillez renseigner le meilleur gardien de la saison");
        }

        return errors;
    }
}
