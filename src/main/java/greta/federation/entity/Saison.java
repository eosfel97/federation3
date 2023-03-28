package greta.federation.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "saison")
public class Saison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_saison")
    private int idSaison;

    @Column(name = "annee", nullable = false)
    private Date annee;

    @Column(name = "nb_but")
    private int nbBut;

    @Column(name = "nb_encaisse")
    private int nbEncaisse;

    @Column(name = "meilleur_joueur", length = 50)
    private String meilleurJoueur;

    @Column(name = "meilleur_buteur", length = 50)
    private String meilleurButeur;

    @Column(name = "meilleur_passeur", length = 50)
    private String meilleurPasseur;

    @Column(name = "meilleur_gardien", length = 50)
    private String meilleurGardien;

    @Column(name = "nb_carton_jaune")
    private int nbCartonJaune;

    @Column(name = "nb_carton_rouge")
    private int nbCartonRouge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competition", referencedColumnName = "id_competition")
    private Competition competition;

    //constructeurs

    public Saison() {
    }

    public Saison(int idSaison, Date annee, int nbBut, int nbEncaisse, String meilleurJoueur, String meilleurButeur, String meilleurPasseur, String meilleurGardien, int nbCartonJaune, int nbCartonRouge, Competition competition) {
        this.idSaison = idSaison;
        this.annee = annee;
        this.nbBut = nbBut;
        this.nbEncaisse = nbEncaisse;
        this.meilleurJoueur = meilleurJoueur;
        this.meilleurButeur = meilleurButeur;
        this.meilleurPasseur = meilleurPasseur;
        this.meilleurGardien = meilleurGardien;
        this.nbCartonJaune = nbCartonJaune;
        this.nbCartonRouge = nbCartonRouge;
        this.competition = competition;
    }
    // getters and setters

    public int getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(int idSaison) {
        this.idSaison = idSaison;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getNbBut() {
        return nbBut;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public int getNbEncaisse() {
        return nbEncaisse;
    }

    public void setNbEncaisse(int nbEncaisse) {
        this.nbEncaisse = nbEncaisse;
    }

    public String getMeilleurJoueur() {
        return meilleurJoueur;
    }

    public void setMeilleurJoueur(String meilleurJoueur) {
        this.meilleurJoueur = meilleurJoueur;
    }

    public String getMeilleurButeur() {
        return meilleurButeur;
    }

    public void setMeilleurButeur(String meilleurButeur) {
        this.meilleurButeur = meilleurButeur;
    }

    public String getMeilleurPasseur() {
        return meilleurPasseur;
    }

    public void setMeilleurPasseur(String meilleurPasseur) {
        this.meilleurPasseur = meilleurPasseur;
    }

    public String getMeilleurGardien() {
        return meilleurGardien;
    }

    public void setMeilleurGardien(String meilleurGardien) {
        this.meilleurGardien = meilleurGardien;
    }

    public int getNbCartonJaune() {
        return nbCartonJaune;
    }

    public void setNbCartonJaune(int nbCartonJaune) {
        this.nbCartonJaune = nbCartonJaune;
    }

    public int getNbCartonRouge() {
        return nbCartonRouge;
    }

    public void setNbCartonRouge(int nbCartonRouge) {
        this.nbCartonRouge = nbCartonRouge;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}