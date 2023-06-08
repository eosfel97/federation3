package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.PlaceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/places")
public interface PlaceApi {
    @PostMapping(value = Constants.DIRECTEUR_ENDPOINT + "/places/creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une place", notes = "Cette méthode permet d'enregistrer ou de modifier une place", response = PlaceDto.class)
    PlaceDto save(@RequestBody PlaceDto dto);


    @GetMapping(value = Constants.APP_ROOT + "/places/filtrer/{aile}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une place par aile", notes = "Cette méthode permet de rechercher une place par son aile", response = PlaceDto.class)
    List<PlaceDto> findByAile(@PathVariable("aile") String aile);

    @GetMapping(value = Constants.APP_ROOT + "/places/filtrer/{ligne}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une place par ligne", notes = "Cette méthode permet de rechercher une place par sa ligne", response = PlaceDto.class)
    List<PlaceDto> findByLigne(@PathVariable("ligne") String ligne);

    @GetMapping(value = Constants.APP_ROOT + "/places/filtrer/{num_ligne}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une place par numéro de ligne", notes = "Cette méthode permet de rechercher une place par son numéro de ligne", response = PlaceDto.class)
    List<PlaceDto> findByNumLigne(@PathVariable("num_ligne") String numLigne);

    @GetMapping(value = Constants.APP_ROOT + "/places/filtrer/{id_stade}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher des places par ID de stade", notes = "Cette méthode permet de rechercher des places en utilisant l'ID du stade associé", responseContainer = "List<PlaceDto>")
    List<PlaceDto> findByStadeId(@PathVariable("id_stade") Integer idStade);

    @GetMapping(value = Constants.APP_ROOT + "/places/tous", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoyer la liste des places", notes = "Cette méthode permet de rechercher et renvoyer la liste des places qui existent dans la base de données", responseContainer = "List<PlaceDto>")
    List<PlaceDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/places/supprimer/{id_place}")
    @ApiOperation(value = "Supprimer une place", notes = "Cette méthode permet de supprimer une place par son ID")
    void delete(@PathVariable("id_place") Integer id);
}
