package greta.federation.controller;
import greta.federation.controller.api.ArticleApi;
import greta.federation.dto.ArticleDto;
import greta.federation.dto.LigneCommandeDto;
import greta.federation.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
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
    public List<ArticleDto> findAllArticleByIdCategorie(Integer id_categorie) {
        return articleService.findAllArticleByIdCategorie(id_categorie);
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
