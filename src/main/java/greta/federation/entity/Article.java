package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="article")
public class Article extends AbstractEntity {


    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;

    @Column(name="prix")
    private BigDecimal prix;

    @Column(name="quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Categorie categorie;
    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommande;

    @Column(name = "photo")
    private String photo;

}