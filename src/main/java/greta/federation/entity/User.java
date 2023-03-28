package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
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

    @Column(name="password")
    private String password;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_roles")
    private Roles roles;

    //constructeurs

    public User() {
    }

    public User(int idUser, String nom, String prenom, String email, String portable, String identifiant, String password, Roles roles) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.portable = portable;
        this.identifiant = identifiant;
        this.password = password;
        this.roles = roles;
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
}