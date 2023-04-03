package greta.federation.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private int idEquipe;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_joueurs")
    private int nbJoueurs;

    @Column(name = "meilleur_buteur")
    private String meilleurButeur;

    @Column(name = "meilleur_passeur")
    private String meilleurPasseur;

    @Column(name = "nb_point_saison")
    private int nbPointSaison;

    @OneToMany (mappedBy ="equipe",cascade=CascadeType.ALL)
    private List<User> users;
    @OneToMany (mappedBy ="equipe",cascade=CascadeType.ALL)
    private List<Joueur> joueurs;
    @ManyToOne
    @JoinColumn(name = "id_saison")
    private Saison saison;

    @ManyToOne
    @JoinColumn(name = "id_categorie_football")
    private CategorieFootball categorieFootball;

    @ManyToOne()
    @JoinColumn(name = "id_club")
    private Club club;

    //constructeurs

    public Equipe() {
    }

    public Equipe(int idEquipe, String nom, int nbJoueurs, String meilleurButeur, String meilleurPasseur, int nbPointSaison, List<User> users, List<Joueur> joueurs, Saison saison, CategorieFootball categorieFootball, Club club) {
        this.idEquipe = idEquipe;
        this.nom = nom;
        this.nbJoueurs = nbJoueurs;
        this.meilleurButeur = meilleurButeur;
        this.meilleurPasseur = meilleurPasseur;
        this.nbPointSaison = nbPointSaison;
        this.users = users;
        this.joueurs = joueurs;
        this.saison = saison;
        this.categorieFootball = categorieFootball;
        this.club = club;
    }

// Getters and setters

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
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

    public int getNbPointSaison() {
        return nbPointSaison;
    }

    public void setNbPointSaison(int nbPointSaison) {
        this.nbPointSaison = nbPointSaison;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public CategorieFootball getCategorieFootball() {
        return categorieFootball;
    }

    public void setCategorieFootball(CategorieFootball categorieFootball) {
        this.categorieFootball = categorieFootball;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

}
