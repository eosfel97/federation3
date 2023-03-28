package greta.federation.entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_roles")
    private int idRoles;

    @Column(name="nom")
    private String nom;

    //constructeurs

    public Roles() {
    }

    public Roles(int idRoles, String nom) {
        this.idRoles = idRoles;
        this.nom = nom;
    }
// getters et setters

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}