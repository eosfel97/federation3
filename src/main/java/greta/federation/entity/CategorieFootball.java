package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorie_football")
public class CategorieFootball extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "nb_joueurs_max_equipe")
    private Integer nbJoueursMaxEquipe;

    @Column(name = "nb_remplacant_equipe")
    private String nbRemplacantEquipe;

    @Column(name = "nb_minute_rencontre")
    private Integer nbMinuteRencontre;

    @Column(name = "nb_mi_temps_rencontre")
    private Short nbMiTempsRencontre;
    @OneToMany(mappedBy = "categorieFootball")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "categorieFootball")
    private List<Competition> competitions;


}