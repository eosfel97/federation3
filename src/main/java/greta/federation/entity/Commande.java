package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "id_ligne_commande")
    private LigneCommande ligneCommande;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    //constructeurs

    public Commande() {
    }

    public Commande(int idCommande, LocalDateTime dateCommande, int nbArticle, double prixTotal, LigneCommande ligneCommande, User user) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.nbArticle = nbArticle;
        this.prixTotal = prixTotal;
        this.ligneCommande = ligneCommande;
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

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
