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

    @Column(name = "numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "Id_Ligne")
    private Ligne ligne;
}
