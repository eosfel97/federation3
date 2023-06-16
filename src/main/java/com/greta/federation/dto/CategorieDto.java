package com.greta.federation.dto;


import com.greta.federation.entity.Article;
import com.greta.federation.entity.Categorie;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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
        List<ArticleDto> articleDtos = categorie.getArticles().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
        return CategorieDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .articles(articleDtos)
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto) {
        if (categorieDto == null) {
            return null;
            // TODO throw an exception
        }
        List<Article> articles = categorieDto.getArticles().stream()
                .map(ArticleDto::toEntity)
                .collect(Collectors.toList());
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNom(categorieDto.getNom());
        categorie.setArticles(articles);
        return categorie;
    }



}
