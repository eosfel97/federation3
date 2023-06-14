package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.LigneDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/lignes")
public interface LigneApi {
    @PostMapping(value = Constants.DIRECTEUR_ENDPOINT + "/lignes/creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une ligne", notes = "Cette méthode permet d'enregistrer ou de modifier une ligne", response = LigneDto.class)
    LigneDto save(@RequestBody LigneDto dto);

    @GetMapping(value = Constants.APP_ROOT + "/lignes/{id_ligne}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Récupérer une ligne par ID", notes = "Cette méthode permet de récupérer une ligne par son ID", response = LigneDto.class)
    LigneDto findById(@PathVariable("id_ligne") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/lignes/tous", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoyer la liste des lignes", notes = "Cette méthode permet de rechercher et renvoyer la liste de toutes les lignes", responseContainer = "List<LigneDto>")
    List<LigneDto> findAll();

    @GetMapping(value = Constants.APP_ROOT + "/lignes/{id_ligne}/places/noms", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi les noms des places par ligne ID", notes = "Cette méthode permet de chercher et renvoyer les noms des places d'une ligne donné par ID", responseContainer = "List<String>")
    List<String> findPlaceNomByLigneId(@PathVariable("id_ligne") Integer ligneId);

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/lignes/supprimer/{id_ligne}")
    @ApiOperation(value = "Supprimer une ligne", notes = "Cette méthode permet de supprimer une ligne par son ID")
    void delete(@PathVariable("id_ligne") Integer id);
}
