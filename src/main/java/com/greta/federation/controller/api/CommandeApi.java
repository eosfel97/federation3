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
    @PostMapping(Constants.APP_ROOT + "/commandes")
    ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto);

    @GetMapping(Constants.APP_ROOT + "/commandes/{idCommandeClient}")
    ResponseEntity<CommandeDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(Constants.APP_ROOT + "/commandes/all")
    ResponseEntity<List<CommandeDto>> findAll();


    @DeleteMapping(Constants.APP_ROOT + "/commandes/{idCommandeClient}")
    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);

}
