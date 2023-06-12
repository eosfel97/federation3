package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Aile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aile extends AbstractEntity {
    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_stade")
    private Stade stade;
}
