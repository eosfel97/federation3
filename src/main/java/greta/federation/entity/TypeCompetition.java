package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_competition")
public class TypeCompetition extends  AbstractEntity {


    @Column(name = "nom", unique = true)
    private String nom;

    @OneToMany(mappedBy = "typeCompetition", cascade=CascadeType.ALL)
    private List<Competition> competitions;

}
