package greta.federation.controller.api;

import greta.federation.dto.CommandeDto;
import greta.federation.dto.LigneCommandeDto;
import greta.federation.entity.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static greta.federation.utils.Constants.APP_ROOT;
@Api("/commandes")
public interface CommandeApi {
    @PostMapping(APP_ROOT + "/commandes/create")
    ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto);



    @PatchMapping(APP_ROOT + "/commandes/update/quantite/{id_Commande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                             @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);
    @PatchMapping(APP_ROOT + "/commandes/update/client/{id_Commande}/{id_User}")
    ResponseEntity<CommandeDto> updateClient(@PathVariable("idCommande") Integer idCommande, @PathVariable("id_User") Integer idClient);

    @PatchMapping(APP_ROOT + "/commandes/update/article/{id_Commande}/{idLigneCommande}/{id_Article}")
    ResponseEntity<CommandeDto> updateArticle(@PathVariable("id_Commande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("id_Article") Integer idArticle);

    @DeleteMapping(APP_ROOT + "/commandes/delete/article/{id_Commande}/{idLigneCommande}")
    ResponseEntity<CommandeDto> deleteArticle(@PathVariable("id_Commande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(APP_ROOT + "/commandes/{idCommandeClient}")
    ResponseEntity<CommandeDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(APP_ROOT + "/commandes/all")
    ResponseEntity<List<CommandeDto>> findAll();
    @GetMapping(APP_ROOT + "/commandes/lignesCommande/{dateCommande}")
    ResponseEntity<List<CommandeDto>>findByDateCommande(@PathVariable("dateCommande")LocalDateTime dateCommande);

    @GetMapping(APP_ROOT + "/commandes/lignesCommande/{id_Commande}")
    ResponseEntity<List<LigneCommandeDto>> findAllLignesCommandesByCommandeId(@PathVariable("id_Commande") Integer idCommande);



    @DeleteMapping(APP_ROOT + "/commandes/delete/{idCommandeClient}")
    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);

}
