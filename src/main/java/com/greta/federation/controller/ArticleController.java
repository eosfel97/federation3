package com.greta.federation.controller;
import com.greta.federation.services.ArticleService;
import com.greta.federation.controller.api.ArticleApi;
import com.greta.federation.dto.ArticleDto;
import com.greta.federation.dto.LigneCommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService ;

    @Autowired
    public ArticleController(
            ArticleService articleService
    ) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }
    @Override
    public ArticleDto update(Integer id, ArticleDto updatedArticle) {
        return articleService.update(id, updatedArticle);
    }
    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByNom(String nom) {
        return articleService.findByNom(nom);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public List<LigneCommandeDto> findHistoriqueCommandeUser(Integer id_article) {
        return articleService.findHistoriqueCommandeUser(id_article);
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
