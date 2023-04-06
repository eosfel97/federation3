package greta.federation.validator;

import greta.federation.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'article");
            errors.add("Veuillez renseigner la description de l'article");
            errors.add("Veuillez renseigner la quantité  de l'article");
            errors.add("Veuillez renseigner le prix  de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'article");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("Veuillez renseigner la description de l'article");
        }
        if (dto.getPrix() == null) {
            errors.add("Veuillez renseigner le prix  de l'article");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantite de l'article");
        }

        if (dto.getCategorie() == null || dto.getCategorie().getId() == null) {
            errors.add("Veuillez selectionner une categorie");
        }
        return errors;
    }
}
