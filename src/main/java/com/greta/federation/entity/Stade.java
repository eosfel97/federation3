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
@Table(name = "stade")
public class Stade extends AbstractEntity {


    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_places")
    private Integer nbPlaces;

    @Column(name = "type_terrain")
    private String typeTerrain;

    @OneToMany (mappedBy ="stade",cascade=CascadeType.ALL)
    private List<Club> clubs;

    @OneToMany (mappedBy ="stade",cascade=CascadeType.ALL)
    private List<Place> places;



}
