package greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.Poste;
import greta.federation.entity.Stade;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class StadeDto {
    private Integer id;
    private String nom;
    private Integer nbPlaces;
    private String typeTerrain;
    @JsonIgnore
    private List<ClubDto> clubs;

    public static StadeDto fromEntity(Stade stade) {
        if (stade == null) {
            return null;
        }
        return StadeDto.builder()
                .id(stade.getId())
                .nom(stade.getNom())
                .nbPlaces(stade.getNbPlaces())
                .typeTerrain(stade.getTypeTerrain())
                .build();
    }
    public static Stade toEntity(StadeDto stadeDto) {
        if (stadeDto == null) {
            return null;
        }
        Stade stade = new Stade();

        stade.setId(stadeDto.getId());
        stade.setNom(stadeDto.getNom());
        stade.setNbPlaces(stadeDto.getNbPlaces());
        stade.setTypeTerrain(stadeDto.getTypeTerrain());

        return stade;
    }
}
