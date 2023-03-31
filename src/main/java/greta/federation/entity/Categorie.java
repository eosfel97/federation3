package greta.federation.entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categorie")
    private int idCategorie;

    @Column(name="nom")
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

    //constructeurs

    public Categorie() {
    }


    public Categorie(int idCategorie, String nom, List<Article> articles) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.articles = articles;
    }
// getters et setters

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}