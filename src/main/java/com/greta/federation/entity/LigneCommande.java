package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ligne_commande")
public class LigneCommande extends AbstractEntity {



    @Column(name="quantite")
    private BigDecimal quantite;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;

    @ManyToOne
    @JoinColumn(name="id_commande")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;


}