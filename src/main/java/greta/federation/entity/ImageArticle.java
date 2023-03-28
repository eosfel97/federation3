package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="image_article")
public class ImageArticle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_image_article")
    private int idImageArticle;

    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_article")
    private Article article;

    //constructeurs

    public ImageArticle() {
    }

    public ImageArticle(int idImageArticle, String nom, String description, Article article) {
        this.idImageArticle = idImageArticle;
        this.nom = nom;
        this.description = description;
        this.article = article;
    }
// getters et setters

    public int getIdImageArticle() {
        return idImageArticle;
    }

    public void setIdImageArticle(int idImageArticle) {
        this.idImageArticle = idImageArticle;
    }

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
