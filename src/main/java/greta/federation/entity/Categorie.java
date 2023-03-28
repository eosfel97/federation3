package greta.federation.entity;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name="categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categorie")
    private int idCategorie;

    @Column(name="nom")
    private String nom;

    //constructeurs

    public Categorie() {
    }

    public Categorie(int idCategorie, String nom) {
        this.idCategorie = idCategorie;
        this.nom = nom;
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
}