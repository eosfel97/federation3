package greta.federation.entity;
import javax.persistence.*;
@Entity
@Table(name = "joueur")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur")
    private int idJoueur;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "poids")
    private String poids;

    @Column(name = "taille")
    private String taille;

    @Column(name = "nb_but")
    private int nbBut;

    @Column(name = "nb_passe_decisive")
    private int nbPasseDecisive;

    @Column(name = "nb_carton_jaune")
    private int nbCartonJaune;

    @Column(name = "nb_carton_rouge")
    private int nbCartonRouge;

    @Column(name = "nb_but_encaisse")
    private int nbButEncaisse;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;
    //constructeurs

    public Joueur() {
    }

    public Joueur(int idJoueur, String prenom, String nom, String poids, String taille, int nbBut, int nbPasseDecisive, int nbCartonJaune, int nbCartonRouge, int nbButEncaisse, Poste poste, Equipe equipe) {
        this.idJoueur = idJoueur;
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.nbBut = nbBut;
        this.nbPasseDecisive = nbPasseDecisive;
        this.nbCartonJaune = nbCartonJaune;
        this.nbCartonRouge = nbCartonRouge;
        this.nbButEncaisse = nbButEncaisse;
        this.poste = poste;
        this.equipe = equipe;
    }
    // Getters and setters

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getNbBut() {
        return nbBut;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public int getNbPasseDecisive() {
        return nbPasseDecisive;
    }

    public void setNbPasseDecisive(int nbPasseDecisive) {
        this.nbPasseDecisive = nbPasseDecisive;
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

    public int getNbButEncaisse() {
        return nbButEncaisse;
    }

    public void setNbButEncaisse(int nbButEncaisse) {
        this.nbButEncaisse = nbButEncaisse;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
