package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_image_article")
    private int idImageArticle;

    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_actualite")
    private Actualite actualite;

    //constructeurs

    public Image() {
    }

    public Image(int idImageArticle, String nom, String description, Article article, Actualite actualite) {
        this.idImageArticle = idImageArticle;
        this.nom = nom;
        this.description = description;
        this.article = article;
        this.actualite = actualite;
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

    public Actualite getActualite() {
        return actualite;
    }

    public void setActualite(Actualite actualite) {
        this.actualite = actualite;
    }
}
