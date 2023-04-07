package greta.federation.services;

import greta.federation.dto.CommandeDto;
import greta.federation.dto.LigneCommandeDto;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public interface CommandeService {
    CommandeDto save(CommandeDto dto);


    CommandeDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

    CommandeDto updateClient(Integer idCommande, Integer idClient);

    CommandeDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);

    // Delete article ==> delete LigneCommandeClient
    CommandeDto deleteArticle(Integer idCommande, Integer idLigneCommande);

    CommandeDto findById(Integer id);

    CommandeDto findByDateCommande(LocalDateTime dateCommande);

    List<CommandeDto> findAll();

    List<LigneCommandeDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

    void delete(Integer id);
}
