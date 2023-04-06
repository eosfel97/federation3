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
@Table(name = "evenement_rencontre")
public class EvenementRencontre extends AbstractEntity {



    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_joueur")
    private Joueur joueur;
    @OneToMany (mappedBy ="evenementRencontre",cascade=CascadeType.ALL)
    private List<Joueur> joueurs;

    @ManyToOne
    @JoinColumn(name = "id_rencontre", nullable = false)
    private Rencontre rencontre;


}
