package com.greta.federation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club")
public class Club extends AbstractEntity {


    @Column(name = "nom", nullable = false, length = 50)
    private String nom;


    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;

    @Column(name = "nom_etablissement_etat", nullable = false, length = 50)
    private String nomEtablissementEtat;

    @Column(name = "nom_assurance", nullable = false, length = 50)
    private String nomAssurance;

    @Column(name = "rib", nullable = false, length = 50)
    private String rib;

    @Column(name = "attestation_assurance", nullable = false, length = 50)
    private String attestationAssurance;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany (mappedBy ="club",cascade=CascadeType.ALL)
    private List<Equipe> equipes;

    @ManyToOne
    @JoinColumn(name = "id_stade")
    private Stade stade;
    @Embedded
    private Adresse adresse;

}