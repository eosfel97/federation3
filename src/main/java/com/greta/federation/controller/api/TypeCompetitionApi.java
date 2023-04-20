package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.TypeCompetitionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/typecompetitions")
public interface TypeCompetitionApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/typecompetitions/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une typecompetitions", notes = "Cette méthode permet de créer ou mettre à jour une typecompetitions", response = TypeCompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet competitions a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet competitions n'est pas valide")
    })
    TypeCompetitionDto create(@RequestBody TypeCompetitionDto dto);

    @PutMapping(value = Constants.ADMIN_ENDPOINT + "/typecompetitions/update/{id_typecompetition}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une typecompetitions", notes = "Cette méthode permet de mettre à jour une typecompetitions existant", response = TypeCompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le typecompetitions a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet typecompetitions n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucune typecompetitions n'existe dans la base de données avec l'ID fourni")
    })
    TypeCompetitionDto update(@PathVariable("id_typecompetition") Integer id, @RequestBody TypeCompetitionDto updatedTypeCompetition);

    @GetMapping(value = Constants.ADMIN_ENDPOINT + "/typecompetitions/{id_typecompetition}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un typecompetitions par ID", notes = "Cette méthode permet de rechercher une typecompetitions par son ID", response = TypeCompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le typecompetitions a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucun typecompetitions n'existe dans la base de données avec l'ID fourni")
    })
    TypeCompetitionDto findById(@PathVariable("id_typecompetition") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/typecompetitions/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des typecompetitions", notes = "Cette méthode permet de rechercher et renvoyer la liste des typecompetitions qui existent dans la base de données", responseContainer = "List<TypeCompetitionDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des typecompetitions / Une liste vide")
    })
    List<TypeCompetitionDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/typecompetitions/delete/{id_typecompetition}")
    @ApiOperation(value = "Supprimer un typecompetitions", notes = "Cette méthode permet de supprimer une typecompetitions par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La typecompetitions a été supprimé"),
            @ApiResponse(code = 404, message = "Aucune typecompetitions n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_typecompetition") Integer id);
}
