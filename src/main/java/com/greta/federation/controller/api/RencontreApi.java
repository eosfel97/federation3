package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.RencontreDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("/rencontres")
public interface RencontreApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/rencontres/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une rencontre", notes = "Cette méthode permet de créer ou mettre à jour une rencontre", response = RencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet rencontre a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet rencontre n'est pas valide")
    })
    RencontreDto create(@RequestBody RencontreDto dto);

    @PutMapping(value = Constants.ADMIN_ENDPOINT + "/rencontres/update/{id_rencontre}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une rencontre", notes = "Cette méthode permet de mettre à jour une rencontre existante", response = RencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La rencontre a été mise à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet rencontre n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucune rencontre n'existe dans la base de données avec l'ID fourni")
    })
    RencontreDto update(@PathVariable("id_rencontre") Integer id, @RequestBody RencontreDto updatedRencontre);

    @GetMapping(value = Constants.APP_ROOT + "/rencontres/{id_rencontre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une rencontre par ID", notes = "Cette méthode permet de rechercher une rencontre par son ID", response = RencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La rencontre a été trouvée dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune rencontre n'existe dans la base de données avec l'ID fourni")
    })
    RencontreDto findById(@PathVariable("id_rencontre") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/rencontres/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des rencontres", notes = "Cette méthode permet de rechercher et renvoyer la liste des rencontres qui existent dans la base de données", responseContainer = "List<RencontreDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des rencontres / Une liste vide")
    })
    List<RencontreDto> findAll();
    @GetMapping(value = Constants.APP_ROOT + "/rencontres/summaries", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des résumés de rencontres", notes = "Cette méthode permet de rechercher et renvoyer la liste des résumés de rencontres qui existent dans la base de données", responseContainer = "List<Map<String, Object>>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des résumés de rencontres / Une liste vide")
    })
    List<Map<String, Object>> findAllSummaries();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/rencontres/delete/{id_rencontre}")
    @ApiOperation(value = "Supprimer une rencontre", notes = "Cette méthode permet de supprimer une rencontre par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La rencontre a été supprimée"),
            @ApiResponse(code = 404, message = "Aucune rencontre n'existe dans la base de données avec l'ID fourni")
    })

    void delete(@PathVariable("id_rencontre") Integer id);
}
