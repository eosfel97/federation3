package greta.federation.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    @Column(name = "nom_rue")
     private String nom_rue;
    @Column(name = "num_rue")
     private int num_rue;
    @Column(name = "libellee_rue")
     private String libellee_rue;
    @Column(name = "ville")
     private String ville;
    @Column(name = "codepostale")
     private  String codePostale;
    @Column(name = "pays")
     private String pays;

    //constructeurs

    public Adresse() {
    }

    public Adresse( String nom_rue, int num_rue, String libellee_rue, String ville, String codePostale, String pays) {
        this.nom_rue = nom_rue;
        this.num_rue = num_rue;
        this.libellee_rue = libellee_rue;
        this.ville = ville;
        this.codePostale = codePostale;
        this.pays = pays;
    }

// getters et setters


    public String getNom_rue() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public int getNum_rue() {
        return num_rue;
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
