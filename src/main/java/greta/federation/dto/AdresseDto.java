package greta.federation.dto;



public class AdresseDto {

    private String nom_rue;

    private int num_rue;

    private String libellee_rue;

    private String ville;

    private  String codePostale;

    private String pays;
    //Getters and Setters


    public String getNom_rue() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public void setNum_rue(int num_rue) {
        this.num_rue = num_rue;
    }

    public String getLibellee_rue() {
        return libellee_rue;
    }

    public void setLibellee_rue(String libellee_rue) {
        this.libellee_rue = libellee_rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
