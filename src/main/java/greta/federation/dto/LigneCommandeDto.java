package greta.federation.dto;

import greta.federation.entity.Equipe;
import greta.federation.entity.LigneCommande;
import greta.federation.entity.Poste;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeDto {
    private Integer id;

    private BigDecimal quantite;


    private BigDecimal prixUnitaire;


    private CommandeDto commande;

    private ArticleDto article;
    public static LigneCommandeDto fromEntity(LigneCommande ligneCommande) {
        if (ligneCommande == null) {
            return null;
        }
        return LigneCommandeDto.builder()
                .id(ligneCommande.getId())
                .quantite(ligneCommande.getQuantite())
                .prixUnitaire(ligneCommande.getPrixUnitaire())
                .commande(CommandeDto.fromEntity(ligneCommande.getCommande()))
                .article(ArticleDto.fromEntity(ligneCommande.getArticle()))
                .build();
    }

    public static LigneCommande toEntity(LigneCommandeDto ligneCommandeDto) {
        if (ligneCommandeDto == null) {
            return null;
        }
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(ligneCommandeDto.getId());
        ligneCommande.setQuantite(ligneCommandeDto.getQuantite());
        ligneCommande.setPrixUnitaire(ligneCommandeDto.getPrixUnitaire());
        ligneCommande.setCommande(CommandeDto.toEntity(ligneCommandeDto.getCommande()));
        ligneCommande.setArticle(ArticleDto.toEntity(ligneCommandeDto.getArticle()));

        return ligneCommande;
    }


}
