package com.greta.federation.dto;

import com.greta.federation.entity.LigneCommande;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<LigneCommandeDto> fromEntityList(List<LigneCommande> ligneCommandes) {
        if (ligneCommandes == null) {
            return Collections.emptyList();
        }
        return ligneCommandes.stream()
                .map(LigneCommandeDto::fromEntity)
                .collect(Collectors.toList());
    }
}