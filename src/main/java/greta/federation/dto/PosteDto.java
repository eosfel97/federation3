package greta.federation.dto;



import java.util.List;

public class PosteDto {

    private String nom;
    private List<JoueurDto> joueurs;

    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<JoueurDto> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<JoueurDto> joueurs) {
        this.joueurs = joueurs;
    }
}
