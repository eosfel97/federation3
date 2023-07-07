package com.greta.federation.services.impl;

import com.greta.federation.dto.ArticleDto;
import com.greta.federation.dto.CategorieDto;
import com.greta.federation.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
public class ArticleServiceImplTest {
    @Autowired
    private ArticleService service;

    @Test
    public void shouldSaveArticleWithSuccess() {
        CategorieDto categorie = new CategorieDto();
        categorie.setId(25);
        categorie.setNom("Categorie");

        ArticleDto expectedArticle = ArticleDto.builder()
                .id(28)
                .nom("Article 1")
                .description("C'est un test")
                .prix(new BigDecimal("10.5"))
                .quantite(new BigDecimal("20"))
                .categorie(categorie)
                .build();
        ArticleDto savedArticle = service.save(expectedArticle);

        assertNotNull(savedArticle);
        assertNotNull(savedArticle.getId());
        assertEquals(savedArticle.getNom(), expectedArticle.getNom());
        assertEquals(savedArticle.getDescription(), expectedArticle.getDescription());
        assertEquals(savedArticle.getPrix(), expectedArticle.getPrix());
        assertEquals(savedArticle.getQuantite(), expectedArticle.getQuantite());
    }
}
