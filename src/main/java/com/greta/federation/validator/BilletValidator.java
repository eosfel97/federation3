package com.greta.federation.validator;

import com.greta.federation.dto.BilletDto;

import java.util.ArrayList;
import java.util.List;

public class BilletValidator {

    public static List<String> validate(BilletDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le numéro du billet");
            errors.add("Veuillez renseigner la date d'achat du billet");
            errors.add("Veuillez renseigner la rencontre associée au billet");
            errors.add("Veuillez renseigner la place associée au billet");
            errors.add("Veuillez renseigner l'utilisateur associé au billet");
            return errors;
        }

        if (dto.getNumero() == null || dto.getNumero().length() < 1) {
            errors.add("Le numéro du billet ne peut pas être nul ou vide");
        }


        if (dto.getDateAchat() == null) {
            errors.add("Veuillez renseigner la date d'achat du billet");
        }

        if (dto.getRencontre() == null) {
            errors.add("Veuillez renseigner la rencontre associée au billet");
        }

        if (dto.getPlace() == null) {
            errors.add("Veuillez renseigner la place associée au billet");
        }

        if (dto.getUser() == null) {
            errors.add("Veuillez renseigner l'utilisateur associé au billet");
        }

        return errors;
    }
}
