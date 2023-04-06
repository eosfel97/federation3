package greta.federation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Users")
public class User extends AbstractEntity {



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

    @OneToMany (mappedBy ="user",cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Roles> roles;

    @OneToMany (mappedBy ="user",cascade=CascadeType.ALL)
    private List<Commande> commandes;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;



}