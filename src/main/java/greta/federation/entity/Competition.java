package greta.federation.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competition")
    private Integer idCompetition;

    @Column(name = "nom", unique = true)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_type_competition")
    private TypeCompetition typeCompetition;

    @ManyToOne
    @JoinColumn(name = "id_categorie_football")
    private CategorieFootball categorieFootball;
    @OneToMany(mappedBy = "competition")
    private List<Rencontre> rencontres;
     //constructeurs

    public Competition() {
    }

    public Competition(Integer idCompetition, String nom, TypeCompetition typeCompetition, CategorieFootball categorieFootball, List<Rencontre> rencontres) {
        this.idCompetition = idCompetition;
        this.nom = nom;
        this.typeCompetition = typeCompetition;
        this.categorieFootball = categorieFootball;
        this.rencontres = rencontres;
    }

//getters and setters

    public Integer getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Integer idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeCompetition getTypeCompetition() {
        return typeCompetition;
    }

    public void setTypeCompetition(TypeCompetition typeCompetition) {
        this.typeCompetition = typeCompetition;
    }

    public CategorieFootball getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootball categorieFootball) {
        this.categorieFootball = categorieFootball;
    }

    public List<Rencontre> getRencontres() {
        return rencontres;
    }

    public void setRencontres(List<Rencontre> rencontres) {
        this.rencontres = rencontres;
    }
}
