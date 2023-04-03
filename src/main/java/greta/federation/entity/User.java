package greta.federation.entity;

import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user")
    private int idUser;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column(name="portable")
    private String portable;

    @Column(name="identifiant")
    private String identifiant;
    @Column(name="password",nullable = false, length = 255)
    private String password;
    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles roles;

    @OneToMany (mappedBy ="user",cascade=CascadeType.ALL)
    private List<Commande> commandes;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    //constructeurs

    public User() {
    }

    public User(int idUser, String nom, String prenom, String email, String portable, String identifiant, String password, Adresse adresse, Roles roles, List<Commande> commandes, Equipe equipe) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.portable = portable;
        this.identifiant = identifiant;
        this.password = password;
        this.adresse = adresse;
        this.roles = roles;
        this.commandes = commandes;
        this.equipe = equipe;
    }

// getters et setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}