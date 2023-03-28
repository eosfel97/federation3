package greta.federation.entity;

import javax.persistence.*;
@Entity
@Table(name = "type_competition")
public class TypeCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_competition")
    private Integer idTypeCompetition;

    @Column(name = "nom", unique = true)
    private String nom;
    // constructeurs

    public TypeCompetition() {
    }

    public TypeCompetition(Integer idTypeCompetition, String nom) {
        this.idTypeCompetition = idTypeCompetition;
        this.nom = nom;
    }
    //getters and setters

    public Integer getIdTypeCompetition() {
        return idTypeCompetition;
    }

    public void setIdTypeCompetition(Integer idTypeCompetition) {
        this.idTypeCompetition = idTypeCompetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
