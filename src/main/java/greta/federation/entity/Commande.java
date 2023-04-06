package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commande")
public class Commande extends AbstractEntity {

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "nb_article")
    private int nbArticle;

    @Column(name = "prix_total")
    private BigDecimal prixTotal;

    @OneToMany(mappedBy = "commande",cascade=CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


}
