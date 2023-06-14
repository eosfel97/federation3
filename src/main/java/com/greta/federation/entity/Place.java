package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place")
public class Place extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name="prix")
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "Id_Ligne")
    private Ligne ligne;
}
