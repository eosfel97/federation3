package greta.federation.entity;
import javax.persistence.*;

@Entity
@Table(name = "evenement_rencontre")
public class EvenementRencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evenement_rencontre")
    private int idEvenementRencontre;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_joueur", nullable = false)
    private Joueur joueur;

    @ManyToOne
    @JoinColumn(name = "id_rencontre", nullable = false)
    private Rencontre rencontre;

    //  constructeurs
    public EvenementRencontre() {}

    public EvenementRencontre(int idEvenementRencontre, String nom, String type, Joueur joueur, Rencontre rencontre) {
        this.idEvenementRencontre = idEvenementRencontre;
        this.nom = nom;
        this.type = type;
        this.joueur = joueur;
        this.rencontre = rencontre;
    }

// Getters and setters

    public int getIdEvenementRencontre() {
        return idEvenementRencontre;
    }

    public void setIdEvenementRencontre(int idEvenementRencontre) {
        this.idEvenementRencontre = idEvenementRencontre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }
}
