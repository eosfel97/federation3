package com.greta.federation.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Article;
import com.greta.federation.entity.LigneCommande;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    public static ArticleDto fromEntity(Article article){

        if(article == null) {
            return  null ;
            // TODO throw an exception
        }
        return  ArticleDto.builder()
                .id(article.getId())
                .prix(article.getPrix())
                .nom(article.getNom())
                .description(article.getDescription())
                .quantite(article.getQuantite())
                .photo(article.getPhoto())
                .ligneCommande(LigneCommandeDto.fromEntityList(article.getLigneCommande()))

                .categorie(CategorieDto.fromEntity(article.getCategorie()))
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
