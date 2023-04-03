package greta.federation.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_competition")
public class TypeCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_competition")
    private Integer idTypeCompetition;

    @Column(name = "nom", unique = true)
    private String nom;

    @OneToMany(mappedBy = "typeCompetition", cascade=CascadeType.ALL)
    private List<Competition> competitions;
    // constructeurs

    public TypeCompetition() {
    }

    public TypeCompetition(Integer idTypeCompetition, String nom, List<Competition> competitions) {
        this.idTypeCompetition = idTypeCompetition;
        this.nom = nom;
        this.competitions = competitions;
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

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
