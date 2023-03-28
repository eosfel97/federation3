package greta.federation.entity;

import javax.persistence.*;
@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Integer idPoste;

    @Column(name = "nom")
    private String nom;

    //constructeurs

    public Poste() {
    }

    public Poste(Integer idPoste, String nom) {
        this.idPoste = idPoste;
        this.nom = nom;
    }
    //getters and setters

    public Integer getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Integer idPoste) {
        this.idPoste = idPoste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
