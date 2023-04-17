package greta.federation.controller.api;

import greta.federation.dto.SaisonDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.ADMIN_ENDPOINT;
import static greta.federation.utils.Constants.APP_ROOT;

@Api("/saisons")
public interface SaisonApi {

    @PostMapping(ADMIN_ENDPOINT + "/saisons/create")
    ResponseEntity<SaisonDto> save(@RequestBody SaisonDto dto);

    @GetMapping(ADMIN_ENDPOINT+"/saisons/{id_saison}")
    ResponseEntity<SaisonDto> findById(@PathVariable("id_saison") Integer id);

    @GetMapping(ADMIN_ENDPOINT+"/saisons/{all}")
    ResponseEntity<List<SaisonDto>> findAll();

    @PutMapping(ADMIN_ENDPOINT+"/saisons/update/{id_saison}")
    ResponseEntity<SaisonDto> update(@PathVariable("id_saison") Integer id, @RequestBody SaisonDto dto);

    @DeleteMapping(ADMIN_ENDPOINT+"/saisons/delete/{id_saison}")
    ResponseEntity<Void> delete(@PathVariable("id_saison") Integer id);
}
