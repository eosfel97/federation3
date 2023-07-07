package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.CategorieFootballDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/categorie-footballs")
public interface CategorieFootballApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT+ "/categoriefootballs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une catégorie de football", notes = "Cette méthode permet de créer ou mettre à jour une catégorie de football", response = CategorieFootballDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La catégorie de football a été créée ou mise à jour avec succès"),
            @ApiResponse(code = 400, message = "Les informations fournies ne sont pas valides")
    })
    CategorieFootballDto save(@RequestBody CategorieFootballDto dto);

    @PutMapping(value = Constants.ADMIN_ENDPOINT+ "/categoriefootballs/{id_categorie_football}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une catégorie de football", notes = "Cette méthode permet de mettre à jour une catégorie de football existante", response = CategorieFootballDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La catégorie de football a été mise à jour avec succès"),
            @ApiResponse(code = 400, message = "Les informations fournies ne sont pas valides"),
            @ApiResponse(code = 404, message = "Aucune catégorie de football n'existe avec l'ID fourni")
    })
    CategorieFootballDto update(@PathVariable("id_categorie_football") Integer id, @RequestBody CategorieFootballDto updatedCategorieFootball);

    @GetMapping(value = Constants.APP_ROOT+ "/categoriefootballs/{id_categorie_football}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une catégorie de football par ID", notes = "Cette méthode permet de rechercher une catégorie de football par son ID", response = CategorieFootballDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La catégorie de football a été trouvée"),
            @ApiResponse(code = 404, message = "Aucune catégorie de football n'existe avec l'ID fourni")
    })
    CategorieFootballDto findById(@PathVariable("id_categorie_football") Integer id);

    @GetMapping(value = Constants.APP_ROOT+ "/categoriefootballs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des catégories de football", notes = "Cette méthode permet de rechercher et renvoyer la liste des catégories de football qui existent dans la base de données", responseContainer = "List<CategorieFootballDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des catégories de football / Une liste vide")
    })
    List<CategorieFootballDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT+"/categoriefootballs/{id_categorie_football}")
    @ApiOperation(value = "Supprimer une catégorie de football", notes = "Cette méthode permet de supprimer une catégorie de football par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La catégorie de football a été supprimée"),
            @ApiResponse(code = 404, message = "Aucune catégorie de football n'existe avec l'ID fourni")
    })
    void delete(@PathVariable("id_categorie_football") Integer id);
}
