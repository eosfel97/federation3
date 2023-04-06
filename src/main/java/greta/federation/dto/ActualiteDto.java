package greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.Actualite;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActualiteDto {
    private Integer id;

    private String titre;


    private String information;

    @JsonIgnore
    private List<ImageDto> images;

    public static ActualiteDto fromEntity(Actualite actualite){

        if(actualite == null) {
            return  null ;
            // TODO throw an exception
        }
        return  ActualiteDto.builder()
                .id(actualite.getId())
                .information(actualite.getInformation())
                .titre(actualite.getTitre())
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

        return actualite;
    }



}
