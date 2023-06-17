package com.greta.federation.validator;

import com.greta.federation.dto.CommandeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeValidator {
    public static List<String> validate(CommandeDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (dto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (dto.getUser() == null || dto.getUser().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }
}
