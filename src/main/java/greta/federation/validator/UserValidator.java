package greta.federation.validator;

import greta.federation.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(userDto.getNom())){
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(userDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(userDto.getEmail())){
            errors.add("L'adresse e-mail est requise!");
        }else {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (!userDto.getEmail().matches(regex)) {
                errors.add("L'adresse e-mail n'est pas valide.");
            }
        }
        if (!StringUtils.hasLength(userDto.getIdentifiant())){
            errors.add("Veuillez renseigner un mot de passe  ");
        }else {
             String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
            if (!userDto.getPassword().matches(regex)) {
                errors.add(" mot de passe doit contenir au minimum 8 caracteres dont 1 maj, 1 min, 1 chiffre et 1 caractere spécial(@$!%*?&)");
            }
        }
        if (!StringUtils.hasLength(userDto.getIdentifiant())){
            errors.add("Veuillez renseigner un indentifiant ");
        }

        if(userDto.getAdresse()== null){
            errors.add("Veuillez renseigner une adresse");
        }else {
            if (!StringUtils.hasLength(userDto.getAdresse().getNom_rue())){
                errors.add("Le nom de la rue est requise! ");
            }
           /* if (!StringUtils.hasLength(userDto.getAdresse().())){
                errors.add("Le numero de la rue est requise ");
            }*/
            if (!StringUtils.hasLength(userDto.getAdresse().getLibellee_rue())){
                errors.add("Le libellée de la rue est requise  ");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getVille())){
                errors.add("La ville est requise ");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getPays())){
                errors.add("Le pays est requise ");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getCodePostale())){
                errors.add("Le code postale est requise ");
            }
        }


        return errors;
    }

}
