package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ligne")
public class Ligne extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "Id_Aile")
    private Aile aile;
}
