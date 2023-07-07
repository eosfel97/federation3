package com.greta.federation.controller.api;

import com.greta.federation.dto.ArbitreDto;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/arbitres")
public interface ArbitreApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/arbitres", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer un arbitre", notes = "Cette méthode permet de créer un arbitre", response = ArbitreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet arbitre a été créé"),
            @ApiResponse(code = 400, message = "L'objet arbitre n'est pas valide")
    })
    ArbitreDto save(@RequestBody ArbitreDto dto);

    @GetMapping(value = Constants.ADMIN_ENDPOINT + "/arbitres/{id_arbitre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un arbitre par ID", notes = "Cette méthode permet de rechercher un arbitre par son ID", response = ArbitreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'arbitre a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucun arbitre n'existe dans la base de données avec l'ID fourni")
    })
    ArbitreDto findById(@PathVariable("id_arbitre") Integer id);

    @GetMapping(value = Constants.APP_ROOT +"/arbitres/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des arbitres", notes = "Cette méthode permet de rechercher et renvoyer la liste des arbitres qui existent dans la base de données", responseContainer = "List<ArbitreDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des arbitres / Une liste vide")
    })
    List<ArbitreDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT +"/arbitres/{id}")
    @ApiOperation(value = "Supprimer un arbitre", notes = "Cette méthode permet de supprimer un arbitre par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'arbitre a été supprimé"),
            @ApiResponse(code = 404, message = "Aucun arbitre n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_arbitre") Integer id);
}
