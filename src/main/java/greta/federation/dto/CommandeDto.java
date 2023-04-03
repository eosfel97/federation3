package greta.federation.dto;


import java.time.LocalDateTime;
import java.util.List;

public class CommandeDto {

    private LocalDateTime dateCommande;


    private int nbArticle;


    private double prixTotal;


    private List<LigneCommandeDto> ligneCommandes;


    private UserDto user;

    // getters and setters


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

    public List<LigneCommandeDto> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommandeDto> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
