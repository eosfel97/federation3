package com.greta.federation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Article;
import com.greta.federation.entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto {
    private Integer id;
    private String nom;
    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategorieDto fromEntity(Categorie categorie) {
        return fromEntity(categorie, true);
    }

    public static CategorieDto fromEntity(Categorie categorie, boolean includeArticles) {
        if (categorie == null) {
            return null;
            // TODO throw an exception
        }
        List<ArticleDto> articleDtos = includeArticles ? categorie.getArticles().stream()
                .map(article -> ArticleDto.fromEntity(article, false))
                .collect(Collectors.toList()) : null;
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
        List<Article> articles = Optional.ofNullable(categorieDto.getArticles())
                .orElse(Collections.emptyList())
                .stream()
                .map(articleDto -> ArticleDto.toEntity(articleDto))
                .collect(Collectors.toList());
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNom(categorieDto.getNom());
        categorie.setArticles(articles);
        return categorie;
    }
}
