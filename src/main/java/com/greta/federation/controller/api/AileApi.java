package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.AileDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/ailes")
public interface AileApi {

    @PostMapping(value = Constants.DIRECTEUR_ENDPOINT + "/ailes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une aile", notes = "Cette méthode permet de créer ou mettre à jour une aile", response = AileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet aile a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet aile n'est pas valide")
    })
    AileDto save(@RequestBody AileDto dto);


    @GetMapping(value = Constants.ADMIN_ENDPOINT + "/ailes/{id_aile}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une aile par ID", notes = "Cette méthode permet de rechercher une aile par son ID", response = AileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'aile a été trouvée dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune aile n'existe dans la base de données avec l'ID fourni")
    })
    AileDto findById (@PathVariable("id_aile") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/ailes/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une aile par nom", notes = "Cette méthode permet de rechercher une aile par son nom", response = AileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'aile a été trouvée dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune aile n'existe dans la base de données avec le nom fourni")
    })
    AileDto findByNom(@PathVariable("nom") String nom);

    @GetMapping(value = Constants.APP_ROOT + "/ailes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoyer la liste des ailes", notes = "Cette méthode permet de rechercher et renvoyer la liste des ailes qui existent dans la base de données", responseContainer = "List<AileDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des ailes / Une liste vide")
    })
    List<AileDto> findAll();


    @GetMapping(value = Constants.APP_ROOT + "/ailes/lignes/{id_aile}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi les noms des lignes par aile ID", notes = "Cette méthode permet de chercher et renvoyer les noms des lignes d'une aile donné par ID", responseContainer = "List<String>")
    List<String> findLigneNomByAileId(@PathVariable("id_aile") Integer aileId);

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/ailes/{id_aile}")
    @ApiOperation(value = "Supprimer une aile", notes = "Cette méthode permet de supprimer une aile par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'aile a été supprimée"),
            @ApiResponse(code = 404, message = "Aucune aile n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_aile") Integer id);
}
