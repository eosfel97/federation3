package greta.federation.dto;

public class ImageArticleDto {
    private String nom;
    private String description;
    private ArticleDto article;
    // GG and SS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }
}
