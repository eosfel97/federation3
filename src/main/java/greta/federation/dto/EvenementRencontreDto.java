package greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.EvenementRencontre;
import greta.federation.entity.Joueur;
import greta.federation.entity.Rencontre;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EvenementRencontreDto {
    private Integer id;
    private String nom;
    private String type;
    private Joueur joueur;
    @JsonIgnore
    private List<Joueur> joueurs;
    private RencontreDto rencontre;

    public static EvenementRencontreDto fromEntity(EvenementRencontre evenementRencontre) {
        if (evenementRencontre == null) {
            return null;
        }
        return EvenementRencontreDto.builder()
                .id(evenementRencontre.getId())
                .nom(evenementRencontre.getNom())
                .type(evenementRencontre.getType())
                .rencontre(RencontreDto.fromEntity(evenementRencontre.getRencontre()))
                .build();
    }
    public static EvenementRencontre toEntity(EvenementRencontreDto evenementRencontreDto) {
        if (evenementRencontreDto == null) {
            return null;
        }
        EvenementRencontre evenementRencontre = new EvenementRencontre();
        evenementRencontre.setId(evenementRencontreDto.getId());
        evenementRencontre.setNom(evenementRencontreDto.getNom());
        evenementRencontre.setType(evenementRencontreDto.getType());
        evenementRencontre.setRencontre(RencontreDto.toEntity(evenementRencontreDto.getRencontre()));

        return evenementRencontre;
    }


}
