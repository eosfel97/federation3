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


    @GetMapping(value = Constants.APP_ROOT + "/places/filtrer/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une place par le nom de la ligne", notes = "Cette méthode permet de rechercher une place par le nom de la ligne", response = PlaceDto.class)
    List<PlaceDto> findByLigne (@PathVariable("nom") String nom);



    @GetMapping(value = Constants.APP_ROOT + "/places/tous", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoyer la liste des places", notes = "Cette méthode permet de rechercher et renvoyer la liste des places qui existent dans la base de données", responseContainer = "List<PlaceDto>")
    List<PlaceDto> findAll();

    @GetMapping(value = Constants.APP_ROOT + "/places/{id_place}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une place par ID", notes = "Cette méthode permet de rechercher une place par son ID", response = PlaceDto.class)
    PlaceDto findById(@PathVariable("id_place") Integer id);

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/places/supprimer/{id_place}")
    @ApiOperation(value = "Supprimer une place", notes = "Cette méthode permet de supprimer une place par son ID")
    void delete(@PathVariable("id_place") Integer id);
}
