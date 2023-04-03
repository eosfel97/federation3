package greta.federation.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rencontre")
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rencontre")
    private int idRencontre;

    @Column(name = "nb_but_domicile")
    private int nbButDomicile;

    @Column(name = "nb_but_exterieur")
    private int nbButExterieur;

    @OneToMany(mappedBy = "rencontre")
    private List<Arbitre>arbitres;
    @ManyToOne
    @JoinColumn(name = "id_exterieur")
    private Equipe equipeExterieure;

    @ManyToOne
    @JoinColumn(name = "id_domicile")
    private Equipe equipeDomicile;

    @ManyToOne
    @JoinColumn(name = "id_competition")
    private Competition competition;

    @OneToMany (mappedBy ="rencontre",cascade=CascadeType.ALL)
    private List<EvenementRencontre> evenementRencontres;
    //constructeurs

    public Rencontre() {
    }

    public Rencontre(int idRencontre, int nbButDomicile, int nbButExterieur, List<Arbitre> arbitres, Equipe equipeExterieure, Equipe equipeDomicile, Competition competition, List<EvenementRencontre> evenementRencontres) {
        this.idRencontre = idRencontre;
        this.nbButDomicile = nbButDomicile;
        this.nbButExterieur = nbButExterieur;
        this.arbitres = arbitres;
        this.equipeExterieure = equipeExterieure;
        this.equipeDomicile = equipeDomicile;
        this.competition = competition;
        this.evenementRencontres = evenementRencontres;
    }

// Getters and setters

    public int getIdRencontre() {
        return idRencontre;
    }

    public void setIdRencontre(int idRencontre) {
        this.idRencontre = idRencontre;
    }

    public int getNbButDomicile() {
        return nbButDomicile;
    }

    public void setNbButDomicile(int nbButDomicile) {
        this.nbButDomicile = nbButDomicile;
    }

    public int getNbButExterieur() {
        return nbButExterieur;
    }

    public void setNbButExterieur(int nbButExterieur) {
        this.nbButExterieur = nbButExterieur;
    }


    public Equipe getEquipeExterieure() {
        return equipeExterieure;
    }

    public List<Arbitre> getArbitres() {
        return arbitres;
    }

    public void setArbitres(List<Arbitre> arbitres) {
        this.arbitres = arbitres;
    }

    public List<EvenementRencontre> getEvenementRencontres() {
        return evenementRencontres;
    }

    public void setEvenementRencontres(List<EvenementRencontre> evenementRencontres) {
        this.evenementRencontres = evenementRencontres;
    }

    public void setEquipeExterieure(Equipe equipeExterieure) {
        this.equipeExterieure = equipeExterieure;
    }

    public Equipe getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(Equipe equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
