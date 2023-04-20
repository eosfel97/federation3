package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "poste")
public class Poste extends AbstractEntity {


    @Column(name = "nom")
    private String nom;
    @OneToMany (mappedBy ="poste",cascade=CascadeType.ALL)
    private List<Joueur> joueurs;


}
