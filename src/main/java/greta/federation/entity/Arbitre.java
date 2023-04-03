package greta.federation.entity;

import javax.persistence.*;
@Entity
@Table(name = "arbitre")
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbitre")
    private Integer idArbitre;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "id_categorie_football")
    private CategorieFootball categorieFootball;

    @ManyToOne
    @JoinColumn(name = "id_rencontre")
    private Rencontre rencontre;
    // constructeurs

    public Arbitre() {
    }

    public Arbitre(Integer idArbitre, String nom, String prenom, CategorieFootball categorieFootball) {
        this.idArbitre = idArbitre;
        this.nom = nom;
        this.prenom = prenom;
        this.categorieFootball = categorieFootball;
    }
    //getters and setters

    public Integer getIdArbitre() {
        return idArbitre;
    }

    public void setIdArbitre(Integer idArbitre) {
        this.idArbitre = idArbitre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public CategorieFootball getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootball categorieFootball) {
        this.categorieFootball = categorieFootball;
    }
}

