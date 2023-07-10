package com.greta.federation.services;

import com.greta.federation.dto.ArticleDto;
import com.greta.federation.dto.LigneCommandeDto;
import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto update(Integer id, ArticleDto updatedArticle);
    ArticleDto findById(Integer id);

    ArticleDto findByNom(String nom);

    List<ArticleDto> findAll();

    List<LigneCommandeDto> findHistoriqueCommandeUser(Integer id_article);


    void delete(Integer id);

}
