package greta.federation.entity;

import javax.persistence.*;
@Entity
@Table(name = "stade")
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stade")
    private Integer idStade;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_places")
    private Integer nbPlaces;

    @Column(name = "type_terrain")
    private String typeTerrain;
    //constructeurs

    public Stade() {
    }

    public Stade(Integer idStade, String nom, Integer nbPlaces, String typeTerrain) {
        this.idStade = idStade;
        this.nom = nom;
        this.nbPlaces = nbPlaces;
        this.typeTerrain = typeTerrain;
    }
    //getters and setters

    public Integer getIdStade() {
        return idStade;
    }

    public void setIdStade(Integer idStade) {
        this.idStade = idStade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getTypeTerrain() {
        return typeTerrain;
    }

    public void setTypeTerrain(String typeTerrain) {
        this.typeTerrain = typeTerrain;
    }
}
