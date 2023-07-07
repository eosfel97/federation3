package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.SaisonDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/saisons")
public interface SaisonApi {

    @PostMapping(Constants.ADMIN_ENDPOINT + "/saisons")
    ResponseEntity<SaisonDto> save(@RequestBody SaisonDto dto);

    @GetMapping(Constants.APP_ROOT+"/saisons/{id_saison}")
    ResponseEntity<SaisonDto> findById(@PathVariable("id_saison") Integer id);

    @GetMapping(Constants.APP_ROOT+"/saisons/all")
    ResponseEntity<List<SaisonDto>> findAll();

    @PutMapping(Constants.ADMIN_ENDPOINT+"/saisons/{id_saison}")
    ResponseEntity<SaisonDto> update(@PathVariable("id_saison") Integer id, @RequestBody SaisonDto dto);

    @DeleteMapping(Constants.ADMIN_ENDPOINT+"/saisons/{id_saison}")
    ResponseEntity<Void> delete(@PathVariable("id_saison") Integer id);
}
