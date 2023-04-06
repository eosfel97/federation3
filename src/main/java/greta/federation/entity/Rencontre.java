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
@Table(name = "rencontre")
public class Rencontre extends AbstractEntity {


    @Column(name = "nb_but_domicile")
    private int nbButDomicile;

    @Column(name = "nb_but_exterieur")
    private int nbButExterieur;

    @OneToMany(mappedBy = "rencontre")
    private List<Arbitre>arbitres;
    @ManyToOne
    @JoinColumn(name = "id_exterieur")
    private Equipe equipeExterieure;

    @ManyToOne
    @JoinColumn(name = "id_domicile")
    private Equipe equipeDomicile;

    @ManyToOne
    @JoinColumn(name = "id_competition")
    private Competition competition;

    @OneToMany (mappedBy ="rencontre",cascade=CascadeType.ALL)
    private List<EvenementRencontre> evenementRencontres;

}
