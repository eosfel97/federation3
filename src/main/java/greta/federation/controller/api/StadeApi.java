package greta.federation.controller.api;

import greta.federation.dto.StadeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.*;

@Api("/stades")
public interface StadeApi {
    @PostMapping(value = DIRECTEUR_ENDPOINT + "/stades/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un stade", notes = "Cette méthode permet d'enregistrer ou modifier un stade", response = StadeDto.class)
    StadeDto save(@RequestBody StadeDto dto);

    @PutMapping(value = DIRECTEUR_ENDPOINT + "/stades/update/{id_stade}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un stade", notes = "Cette méthode permet de mettre à jour un stade existant", response = StadeDto.class)
    StadeDto update(@PathVariable("id_stade") Integer id, @RequestBody StadeDto updatedStade);

    @GetMapping(value = APP_ROOT + "/stades/filter/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un stade par nom", notes = "Cette méthode permet de chercher un stade par son nom", response = StadeDto.class)
    StadeDto findByNom(@PathVariable("nom") String nom);
    @GetMapping(value = ADMIN_ENDPOINT + "/stades/{id_stade}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un stade par ID", notes = "Cette méthode permet de chercher un stade par son ID", response = StadeDto.class)
    StadeDto findById(@PathVariable("id_stade") Integer id);

    @GetMapping(value = APP_ROOT + "/stades/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des stades", notes = "Cette méthode permet de chercher et renvoyer la liste des stades qui existent dans la base de données", responseContainer = "List<StadeDto>")
    List<StadeDto> findAll();

    @DeleteMapping(value = ADMIN_ENDPOINT + "/stades/delete/{id_stade}")
    @ApiOperation(value = "Supprimer un stade", notes = "Cette méthode permet de supprimer un stade par ID")
    void delete(@PathVariable("id_stade") Integer id);
}
