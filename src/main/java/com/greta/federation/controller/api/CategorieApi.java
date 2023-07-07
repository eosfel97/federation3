package com.greta.federation.controller.api;

import com.greta.federation.dto.CategorieDto;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("categories")
public interface CategorieApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categorie", notes = "Cette methode permet d'enregistrer ou modifier une categorie", response =
            CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet category cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet category n'est pas valide")
    })
    CategorieDto save(@RequestBody CategorieDto dto);

    @GetMapping(value = Constants.APP_ROOT + "/categories/{id_categorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie par ID", notes = "Cette methode permet de chercher une categorie par son ID", response =
            CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BDD avec l'ID fourni")
    })
    CategorieDto findById(@PathVariable("id_categorie") Integer idCategory);

    @GetMapping(value = Constants.APP_ROOT + "/categories/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie par Nom", notes = "Cette methode permet de chercher une categorie par son Nom", response =
            CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    CategorieDto findByNom(@PathVariable("nom") String nom);

    @GetMapping(value = Constants.APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des categories", notes = "Cette methode permet de chercher et renvoyer la liste des categories qui existent "
            + "dans la BDD", responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<CategorieDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/categories/{id_categorie}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer une categorie par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete supprime")
    })
    void delete(@PathVariable("id_categorie") Integer id);

}
