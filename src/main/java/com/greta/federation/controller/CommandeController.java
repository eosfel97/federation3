package com.greta.federation.controller;

import com.greta.federation.controller.api.CommandeApi;
import com.greta.federation.dto.CommandeDto;
import com.greta.federation.dto.LigneCommandeDto;
import com.greta.federation.services.CommandeService;
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
    public ResponseEntity<CommandeDto> findById(Integer id) {
        return ResponseEntity.ok(commandeService.findById(id));
    }



    @Override
    public ResponseEntity<List<CommandeDto>> findAll() {
        return ResponseEntity.ok(commandeService.findAll());
    }


    @Override
    public ResponseEntity<Void> delete(Integer id) {
        commandeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
