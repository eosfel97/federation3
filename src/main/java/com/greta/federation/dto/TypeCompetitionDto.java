package com.greta.federation.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.TypeCompetition;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class TypeCompetitionDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private List<CompetitionDto> competitions;
    public static TypeCompetitionDto fromEntity(TypeCompetition typeCompetition) {
        if (typeCompetition == null) {
            return null;
        }
        return TypeCompetitionDto.builder()
                .id(typeCompetition.getId())
                .nom(typeCompetition.getNom())
                .build();
    }
    public static TypeCompetition toEntity(TypeCompetitionDto typeCompetitionDto) {
        if (typeCompetitionDto == null) {
            return null;
        }
        TypeCompetition typeCompetition = new TypeCompetition();

        typeCompetition.setId(typeCompetitionDto.getId());
        typeCompetition.setNom(typeCompetitionDto.getNom());


        return typeCompetition;
    }

}
