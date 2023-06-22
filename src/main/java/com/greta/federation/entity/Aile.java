package com.greta.federation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JsonBackReference
    private Stade stade;

    @OneToMany (mappedBy ="aile",cascade=CascadeType.ALL)
    private List<Ligne> lignes;

}
