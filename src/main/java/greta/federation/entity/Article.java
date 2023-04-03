package greta.federation.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_article")
    private int idArticle;

    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;

    @Column(name="prix")
    private double prix;

    @Column(name="quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Categorie categorie;

    @OneToMany(mappedBy="article", cascade=CascadeType.ALL)
    private List<Image> images;

    //constructeurs

    public Article() {
    }

    public Article(int idArticle, String nom, String description, double prix, int quantite, Categorie categorie, List<Image> images) {
        this.idArticle = idArticle;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
        this.images = images;
    }

// getters et setters

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}