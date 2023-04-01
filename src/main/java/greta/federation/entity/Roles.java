package greta.federation.entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_roles")
    private int idRoles;

    @Column(name="nom")
    private String nom;
    @OneToMany (mappedBy ="roles",cascade=CascadeType.ALL)
    private List<User> users;

    //constructeurs

    public Roles() {
    }

    public Roles(int idRoles, String nom, List<User> users) {
        this.idRoles = idRoles;
        this.nom = nom;
        this.users = users;
    }

    // getters et setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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