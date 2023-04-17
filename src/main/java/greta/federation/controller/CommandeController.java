package greta.federation.controller;

import greta.federation.controller.api.CommandeApi;
import greta.federation.dto.CommandeDto;
import greta.federation.dto.LigneCommandeDto;
import greta.federation.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@RestController

public class CommandeController implements CommandeApi {
    private final  CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Override
    public ResponseEntity<CommandeDto> save(CommandeDto dto) {
        return ResponseEntity.ok(commandeService.save(dto));
    }


    @Override
    public ResponseEntity<CommandeDto> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return ResponseEntity.ok(commandeService.updateQuantiteCommande(idCommande, idLigneCommande, quantite));
    }

    @Override
    public ResponseEntity<CommandeDto> updateClient(Integer idCommande, Integer idUser) {
        return ResponseEntity.ok(commandeService.updateClient(idCommande, idUser));
    }

    @Override
    public ResponseEntity<CommandeDto> updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
        return ResponseEntity.ok(commandeService.updateArticle(idCommande, idLigneCommande, idArticle));
    }

    @Override
    public ResponseEntity<CommandeDto> deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return ResponseEntity.ok(commandeService.deleteArticle(idCommande, idLigneCommande));
    }

    @Override
    public ResponseEntity<CommandeDto> findById(Integer id) {
        return ResponseEntity.ok(commandeService.findById(id));
    }



    @Override
    public ResponseEntity<List<CommandeDto>> findAll() {
        return ResponseEntity.ok(commandeService.findAll());
    }

    @Override
    public  ResponseEntity<List<CommandeDto>>findByDateCommande(LocalDateTime dateCommande){
        return  ResponseEntity.ok(commandeService.findByDateCommande( dateCommande));
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> findAllLignesCommandesByCommandeId(Integer idCommande) {
        return ResponseEntity.ok(commandeService.findAllLignesCommandesByCommandeId(idCommande));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        commandeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
