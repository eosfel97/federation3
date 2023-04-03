package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie_football")
public class CategorieFootball {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie_football")
    private Integer idCategorieFootball;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_joueurs_max_equipe")
    private Integer nbJoueursMaxEquipe;

    @Column(name = "nb_remplacant_equipe")
    private String nbRemplacantEquipe;

    @Column(name = "nb_minute_rencontre")
    private Integer nbMinuteRencontre;

    @Column(name = "nb_mi_temps_rencontre")
    private Short nbMiTempsRencontre;
    @OneToMany(mappedBy = "categorieFootball")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "categorieFootball")
    private List<Competition> competitions;

    //constructeurs

    public CategorieFootball() {
    }

    public CategorieFootball(Integer idCategorieFootball, String nom, Integer nbJoueursMaxEquipe, String nbRemplacantEquipe, Integer nbMinuteRencontre, Short nbMiTempsRencontre, List<Equipe> equipes, List<Competition> competitions) {
        this.idCategorieFootball = idCategorieFootball;
        this.nom = nom;
        this.nbJoueursMaxEquipe = nbJoueursMaxEquipe;
        this.nbRemplacantEquipe = nbRemplacantEquipe;
        this.nbMinuteRencontre = nbMinuteRencontre;
        this.nbMiTempsRencontre = nbMiTempsRencontre;
        this.equipes = equipes;
        this.competitions = competitions;
    }

//getters and setters

    public Integer getIdCategorieFootball() {
        return idCategorieFootball;
    }

    public void setIdCategorieFootball(Integer idCategorieFootball) {
        this.idCategorieFootball = idCategorieFootball;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbJoueursMaxEquipe() {
        return nbJoueursMaxEquipe;
    }

    public void setNbJoueursMaxEquipe(Integer nbJoueursMaxEquipe) {
        this.nbJoueursMaxEquipe = nbJoueursMaxEquipe;
    }

    public String getNbRemplacantEquipe() {
        return nbRemplacantEquipe;
    }

    public void setNbRemplacantEquipe(String nbRemplacantEquipe) {
        this.nbRemplacantEquipe = nbRemplacantEquipe;
    }

    public Integer getNbMinuteRencontre() {
        return nbMinuteRencontre;
    }

    public void setNbMinuteRencontre(Integer nbMinuteRencontre) {
        this.nbMinuteRencontre = nbMinuteRencontre;
    }

    public Short getNbMiTempsRencontre() {
        return nbMiTempsRencontre;
    }

    public void setNbMiTempsRencontre(Short nbMiTempsRencontre) {
        this.nbMiTempsRencontre = nbMiTempsRencontre;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}