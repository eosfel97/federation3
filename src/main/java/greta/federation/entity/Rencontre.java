package greta.federation.entity;
import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "id_arbitre")
    private Arbitre arbitre;

    @ManyToOne
    @JoinColumn(name = "id_exterieur")
    private Equipe equipeExterieure;

    @ManyToOne
    @JoinColumn(name = "id_domicile")
    private Equipe equipeDomicile;

    @ManyToOne
    @JoinColumn(name = "id_competition")
    private Competition competition;
    //constructeurs

    public Rencontre() {
    }

    public Rencontre(int idRencontre, int nbButDomicile, int nbButExterieur, Arbitre arbitre, Equipe equipeExterieure, Equipe equipeDomicile, Competition competition) {
        this.idRencontre = idRencontre;
        this.nbButDomicile = nbButDomicile;
        this.nbButExterieur = nbButExterieur;
        this.arbitre = arbitre;
        this.equipeExterieure = equipeExterieure;
        this.equipeDomicile = equipeDomicile;
        this.competition = competition;
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

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    public Equipe getEquipeExterieure() {
        return equipeExterieure;
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
