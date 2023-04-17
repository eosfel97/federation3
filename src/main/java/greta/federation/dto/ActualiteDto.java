package greta.federation.dto;

import greta.federation.entity.Actualite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActualiteDto {
    private Integer id;

    private String titre;

    private String information;

    private String photo;

    public static ActualiteDto fromEntity(Actualite actualite) {

        if (actualite == null) {
            return null;
        }
        return ActualiteDto.builder()
                .id(actualite.getId())
                .information(actualite.getInformation())
                .titre(actualite.getTitre())
                .photo(actualite.getPhoto())
                .build();
    }

    public static Actualite toEntity(ActualiteDto actualiteDto) {
        if (actualiteDto == null) {
            return null;
        }
        Actualite actualite = new Actualite();

        actualite.setId(actualiteDto.getId());
        actualite.setInformation(actualiteDto.getInformation());
        actualite.setTitre(actualiteDto.getTitre());
       actualite.setPhoto(actualiteDto.getPhoto());

        return actualite;
    }
}
