package greta.federation.dto;

import greta.federation.entity.Article;

import java.util.List;

public class CategorieDto {
    private String nom;
    private List<ArticleDto> articles;
    // GG and SS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }
}
