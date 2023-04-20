package com.greta.federation.dto;


import com.greta.federation.entity.Categorie;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategorieDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private List<ArticleDto> articles;



    public static CategorieDto fromEntity(Categorie categorie) {
        if (categorie == null) {
            return null;
            // TODO throw an exception
        }

        return CategorieDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto) {
        if (categorieDto == null) {
            return null;
            // TODO throw an exception
        }

        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNom(categorieDto.getNom());

        return categorie;
    }



}
