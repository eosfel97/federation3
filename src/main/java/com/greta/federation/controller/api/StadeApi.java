package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.StadeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/stades")
public interface StadeApi {
    @PostMapping(value = Constants.DIRECTEUR_ENDPOINT + "/stades/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un stade", notes = "Cette méthode permet d'enregistrer ou modifier un stade", response = StadeDto.class)
    StadeDto save(@RequestBody StadeDto dto);

    @PutMapping(value = Constants.DIRECTEUR_ENDPOINT + "/stades/update/{id_stade}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un stade", notes = "Cette méthode permet de mettre à jour un stade existant", response = StadeDto.class)
    StadeDto update(@PathVariable("id_stade") Integer id, @RequestBody StadeDto updatedStade);

    @GetMapping(value = Constants.APP_ROOT + "/stades/filter/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un stade par nom", notes = "Cette méthode permet de chercher un stade par son nom", response = StadeDto.class)
    StadeDto findByNom(@PathVariable("nom") String nom);
    @GetMapping(value = Constants.APP_ROOT + "/stades/{id_stade}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un stade par ID", notes = "Cette méthode permet de chercher un stade par son ID", response = StadeDto.class)
    StadeDto findById(@PathVariable("id_stade") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/stades/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des stades", notes = "Cette méthode permet de chercher et renvoyer la liste des stades qui existent dans la base de données", responseContainer = "List<StadeDto>")
    List<StadeDto> findAll();

    @GetMapping(value = Constants.APP_ROOT + "/stades/{id_stade}/ailes/noms", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi les noms des ailes par stade ID", notes = "Cette méthode permet de chercher et renvoyer les noms des ailes d'un stade donné par ID", responseContainer = "List<String>")
    List<String> findAileNomByStadeId(@PathVariable("id_stade") Integer stadeId);

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/stades/delete/{id_stade}")
    @ApiOperation(value = "Supprimer un stade", notes = "Cette méthode permet de supprimer un stade par ID")
    void delete(@PathVariable("id_stade") Integer id);
}
