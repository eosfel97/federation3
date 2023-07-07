package com.greta.federation.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Article;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

import java.util.List;


@Data
@Builder
public class ArticleDto {

    private Integer id;
    private String nom;
    private String description;
    private BigDecimal prix;
    private BigDecimal quantite;
    private CategorieDto categorie;
    @JsonIgnore
    private List<LigneCommandeDto> ligneCommande;

    private String photo;


    public static ArticleDto fromEntity(Article article) {
        return fromEntity(article, true);
    }

    public static ArticleDto fromEntity(Article article, boolean includeLigneCommande) {
        if (article == null) {
            return null;
            // TODO throw an exception
        }
        List<LigneCommandeDto> ligneCommandeDtos = includeLigneCommande ? LigneCommandeDto.fromEntityList(article.getLigneCommande()) : null;
        return ArticleDto.builder()
                .id(article.getId())
                .prix(article.getPrix())
                .nom(article.getNom())
                .description(article.getDescription())
                .quantite(article.getQuantite())
                .photo(article.getPhoto())
                .ligneCommande(ligneCommandeDtos)
                .categorie(CategorieDto.fromEntity(article.getCategorie(), false))
                .build();
    }


    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();

        article.setId(articleDto.getId());
        article.setNom(articleDto.getNom());
        article.setPrix(articleDto.getPrix());
        article.setQuantite(articleDto.getQuantite());
        article.setDescription(articleDto.getDescription());
        article.setPhoto(articleDto.getPhoto());
        article.setCategorie(CategorieDto.toEntity(articleDto.getCategorie()));
        return article;
    }

}
