package greta.federation.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Integer idPoste;

    @Column(name = "nom")
    private String nom;
    @OneToMany (mappedBy ="poste",cascade=CascadeType.ALL)
    private List<Joueur> joueurs;

    //constructeurs

    public Poste() {
    }

    public Poste(Integer idPoste, String nom, List<Joueur> joueurs) {
        this.idPoste = idPoste;
        this.nom = nom;
        this.joueurs = joueurs;
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

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
