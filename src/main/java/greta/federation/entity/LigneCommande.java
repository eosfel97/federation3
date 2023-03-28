package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="ligne_commande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ligne_commande")
    private int idLigneCommande;

    @Column(name="quantite")
    private int quantite;

    @Column(name="prix_unitaire")
    private double prixUnitaire;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_article")
    private Article article;

    //constructeurs

    public LigneCommande() {
    }

    public LigneCommande(int idLigneCommande, int quantite, double prixUnitaire, Article article) {
        this.idLigneCommande = idLigneCommande;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.article = article;
    }
// getters et setters

    public int getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(int idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}