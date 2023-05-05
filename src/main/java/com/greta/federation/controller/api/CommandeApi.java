package com.greta.federation.controller.api;

import com.greta.federation.dto.CommandeDto;
import com.greta.federation.dto.LigneCommandeDto;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Api("/commandes")
public interface CommandeApi {
    @PostMapping(Constants.APP_ROOT + "/commandes/create")
    ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto);



    @PatchMapping(Constants.APP_ROOT + "/commandes/update/quantite/{id_Commande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                             @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);
    @PatchMapping(Constants.APP_ROOT + "/commandes/update/client/{id_Commande}/{id_User}")
    ResponseEntity<CommandeDto> updateClient(@PathVariable("idCommande") Integer idCommande, @PathVariable("id_User") Integer idClient);

    @PatchMapping(Constants.APP_ROOT + "/commandes/update/article/{id_Commande}/{idLigneCommande}/{id_Article}")
    ResponseEntity<CommandeDto> updateArticle(@PathVariable("id_Commande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("id_Article") Integer idArticle);

    @DeleteMapping(Constants.APP_ROOT + "/commandes/delete/article/{id_Commande}/{idLigneCommande}")
    ResponseEntity<CommandeDto> deleteArticle(@PathVariable("id_Commande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(Constants.APP_ROOT + "/commandes/{idCommandeClient}")
    ResponseEntity<CommandeDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(Constants.APP_ROOT + "/commandes/all")
    ResponseEntity<List<CommandeDto>> findAll();
    @GetMapping(Constants.APP_ROOT + "/commandes/lignesCommande/{dateCommande}")
    ResponseEntity<List<CommandeDto>>findByDateCommande(@PathVariable("dateCommande")LocalDateTime dateCommande);

    @GetMapping(Constants.APP_ROOT + "/commandes/lignesCommande/{id_Commande}")
    ResponseEntity<List<LigneCommandeDto>> findAllLignesCommandesByCommandeId(@PathVariable("id_Commande") Integer idCommande);



    @DeleteMapping(Constants.APP_ROOT + "/commandes/delete/{idCommandeClient}")
    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);

}
