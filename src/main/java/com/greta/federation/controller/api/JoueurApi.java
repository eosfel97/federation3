package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.JoueurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/joueurs")
public interface JoueurApi {

    @PostMapping(value = Constants.DIRECTEUR_ENDPOINT + "/joueurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer un joueur", notes = "Cette méthode permet de créer ou mettre à jour un joueur", response = JoueurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet joueur a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet joueur n'est pas valide")
    })
    JoueurDto save(@RequestBody JoueurDto dto);

    @PutMapping(value = Constants.DIRECTEUR_ENDPOINT + "/joueurs/update/{id_joueur}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un joueur", notes = "Cette méthode permet de mettre à jour un joueur existant", response = JoueurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le joueur a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet joueur n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucun joueur n'existe dans la base de données avec l'ID fourni")
    })
    JoueurDto update(@PathVariable("id_joueur") Integer id, @RequestBody JoueurDto updatedJoueur);

    @GetMapping(value = Constants.ADMIN_ENDPOINT + "/joueurs/{id_joueur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un joueur par ID", notes = "Cette méthode permet de rechercher un joueur par son ID", response = JoueurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le joueur a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucun joueur n'existe dans la base de données avec l'ID fourni")
    })
    JoueurDto findById(@PathVariable("id_joueur") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/joueurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des joueurs", notes = "Cette méthode permet de rechercher et renvoyer la liste des joueurs qui existent dans la base de données", responseContainer = "List<JoueurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des joueurs / Une liste vide")
    })
    List<JoueurDto> findAll();


    @DeleteMapping(value = Constants.DIRECTEUR_ENDPOINT + "/joueurs/delete/{id_joueur}")
    @ApiOperation(value = "Supprimer un joueur", notes = "Cette méthode permet de supprimer un joueur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le joueur a été supprimé"),
            @ApiResponse(code = 404, message = "Aucun joueur n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_joueur") Integer id);
}

