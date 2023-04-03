package greta.federation.dto;


public class LigneCommandeDto {

    private int quantite;


    private double prixUnitaire;


    private CommandeDto commande;

    private ArticleDto article;

    // getters and setters


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

    public CommandeDto getCommande() {
        return commande;
    }

    public void setCommande(CommandeDto commande) {
        this.commande = commande;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }
}
