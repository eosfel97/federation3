package com.greta.federation.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greta.federation.entity.Commande;
import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.LigneCommande;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class CommandeDto {
    private Integer id;
    private LocalDateTime dateCommande;
    private int nbArticle;
    private BigDecimal prixTotal;

    private List<LigneCommandeDto> ligneCommandes;
    private UserDto user;
    public static CommandeDto fromEntity(Commande commande){

        if(commande == null) {
            return  null ;
            // TODO throw an exception
        }
        List<LigneCommandeDto> ligneCommandeDtos = commande.getLigneCommandes().stream()
                .map(LigneCommandeDto::fromEntity)
                .collect(Collectors.toList());

        return  CommandeDto.builder()
                .id(commande.getId())
                .dateCommande(commande.getDateCommande())
                .nbArticle(commande.getNbArticle())
                .prixTotal(commande.getPrixTotal())
                .user(UserDto.fromEntity(commande.getUser()))
                .ligneCommandes(ligneCommandeDtos)
                .build();
    }
    public static Commande toEntity(CommandeDto commandeDto) {
        if (commandeDto == null) {
            return null;
        }
        List<LigneCommande> ligneCommandes1 = commandeDto.getLigneCommandes().stream()
                .map(LigneCommandeDto::toEntity)
                .collect(Collectors.toList());

        Commande commande = new Commande();
        commande.setId(commandeDto.getId());
        commande.setDateCommande(commandeDto.getDateCommande());
        commande.setNbArticle(commandeDto.getNbArticle());
        commande.setPrixTotal(commandeDto.getPrixTotal());
        commande.setUser(UserDto.toEntity(commandeDto.getUser()));
        commande.setLigneCommandes(ligneCommandes1);

        return commande;
    }



}
