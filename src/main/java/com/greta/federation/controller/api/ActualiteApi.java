package com.greta.federation.controller.api;

import com.greta.federation.dto.ActualiteDto;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/actualites")
public interface ActualiteApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/actualites/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une actualité", notes = "Cette méthode permet d'enregistrer ou modifier une actualité", response = ActualiteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet actualité a été créé ou modifié"),
            @ApiResponse(code = 400, message = "L'objet actualité n'est pas valide")
    })
    ActualiteDto save(@RequestBody ActualiteDto dto);

    @PutMapping(value = Constants.ADMIN_ENDPOINT + "/actualites/update/{id_actualite}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une actualité", notes = "Cette méthode permet de mettre à jour une actualité existante", response = ActualiteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'actualité a été mise à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet actualité n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucune actualité n'existe dans la BDD avec l'ID fourni")
    })
    ActualiteDto update(@PathVariable("id_actualite") Integer id, @RequestBody ActualiteDto updatedActualite);

    @GetMapping(value = Constants.ADMIN_ENDPOINT + "/actualites/{id_actualite}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une actualité par ID", notes = "Cette méthode permet de chercher une actualité par son ID", response = ActualiteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'actualité a été trouvée dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune actualité n'existe dans la BDD avec l'ID fourni")
    })
    ActualiteDto findById(@PathVariable("id_actualite") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/actualites/filter/{titre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une actualité par titre", notes = "Cette méthode permet de chercher une actualité par son titre", response = ActualiteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'actualité a été trouvée dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune actualité n'existe dans la BDD avec le titre fourni")
    })
    ActualiteDto findByTitre(@PathVariable("titre") String titre);

    @GetMapping(value = Constants.APP_ROOT + "/actualites/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des actualités", notes = "Cette méthode permet de chercher et renvoyer la liste des actualités qui existent dans la BDD", responseContainer = "List<ActualiteDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des actualités / Une liste vide")
    })
    List<ActualiteDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/actualites/delete/{id_actualite}")
    @ApiOperation(value = "Supprimer une actualité", notes = "Cette méthode permet de supprimer une actualité par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'actualité a été supprimée")
    })
    void delete(@PathVariable("id_actualite") Integer id);
}

