package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande")
    private int idCommande;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "nb_article")
    private int nbArticle;

    @Column(name = "prix_total")
    private double prixTotal;

    @OneToMany(mappedBy = "commande",cascade=CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    //constructeurs

    public Commande() {
    }

    public Commande(int idCommande, LocalDateTime dateCommande, int nbArticle, double prixTotal, List<LigneCommande> ligneCommandes, User user) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.nbArticle = nbArticle;
        this.prixTotal = prixTotal;
        this.ligneCommandes = ligneCommandes;
        this.user = user;
    }

    // getters and setters


    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getNbArticle() {
        return nbArticle;
    }

    public void setNbArticle(int nbArticle) {
        this.nbArticle = nbArticle;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}
