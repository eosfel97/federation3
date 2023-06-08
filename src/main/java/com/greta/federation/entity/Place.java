package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place")
public class Place extends AbstractEntity {

    @Column(name = "aile")
    private String aile;

    @Column(name = "ligne")
    private String ligne;

    @Column(name = "num_ligne")
    private String numLigne;

    @ManyToOne
    @JoinColumn(name = "id_stade")
    private Stade stade;
}
