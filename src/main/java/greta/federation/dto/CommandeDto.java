package greta.federation.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.Commande;
import greta.federation.entity.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
public class CommandeDto {
    private Integer id;
    private LocalDateTime dateCommande;
    private int nbArticle;
    private BigDecimal prixTotal;
    @JsonIgnore
    private List<LigneCommandeDto> ligneCommandes;
    private UserDto user;
    private EtatCommande etatCommande;
    public static CommandeDto fromEntity(Commande commande){

        if(commande == null) {
            return  null ;
            // TODO throw an exception
        }
        return  CommandeDto.builder()
                .id(commande.getId())
                .dateCommande(commande.getDateCommande())
                .nbArticle(commande.getNbArticle())
                .prixTotal(commande.getPrixTotal())
                .user(UserDto.fromEntity(commande.getUser()))
                .build();
    }
    public static Commande toEntity(CommandeDto commandeDto) {
        if (commandeDto == null) {
            return null;
        }
        Commande commande = new Commande();
        commande.setId(commandeDto.getId());
        commande.setDateCommande(commandeDto.getDateCommande());
        commande.setNbArticle(commandeDto.getNbArticle());
        commande.setPrixTotal(commandeDto.getPrixTotal());
        commande.setUser(UserDto.toEntity(commandeDto.getUser()));

        return commande;
    }
    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }


}
