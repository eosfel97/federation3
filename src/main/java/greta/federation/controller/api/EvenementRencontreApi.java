package greta.federation.controller.api;


import greta.federation.dto.CompetitionDto;
import greta.federation.dto.EvenementRencontreDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.*;

@Api("/evenements-rencontres")
public interface  EvenementRencontreApi {


    @PostMapping(value = ADMIN_ENDPOINT + "/evenements-rencontres/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une evenementsrencontres", notes = "Cette méthode permet de créer ou mettre à jour une evenementsrencontres", response = EvenementRencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet evenementsrencontres a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet evenementsrencontres n'est pas valide")
    })
    EvenementRencontreDto create(@RequestBody EvenementRencontreDto dto);

    @PutMapping(value = ADMIN_ENDPOINT + "/evenements-rencontres/update/{id_evenement_rencontre}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une evenementsrencontres", notes = "Cette méthode permet de mettre à jour une evenementsrencontres existant", response = EvenementRencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L' evenementsrencontres a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet evenementsrencontres n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucune evenementsrencontres n'existe dans la base de données avec l'ID fourni")
    })
    EvenementRencontreDto update(@PathVariable("id_evenement_rencontre") Integer id, @RequestBody EvenementRencontreDto updatedEvenementRencontre);

    @GetMapping(value = ADMIN_ENDPOINT + "/evenements-rencontres/{id_evenement_rencontre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une evenementsrencontres par ID", notes = "Cette méthode permet de rechercher une evenementsrencontres par son ID", response = EvenementRencontreDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L' evenementsrencontres a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune evenementsrencontres n'existe dans la base de données avec l'ID fourni")
    })
    EvenementRencontreDto findById(@PathVariable("id_evenement_rencontre") Integer id);

    @GetMapping(value = APP_ROOT + "/evenements-rencontres/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des evenementsrencontres", notes = "Cette méthode permet de rechercher et renvoyer la liste des evenementsrencontres qui existent dans la base de données", responseContainer = "List<CompetitionDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evenementsrencontres / Une liste vide")
    })
    List<EvenementRencontreDto> findAll();

    @DeleteMapping(value = ADMIN_ENDPOINT + "/evenements-rencontres/delete/{id_evenement_rencontre}")
    @ApiOperation(value = "Supprimer un evenementsrencontres", notes = "Cette méthode permet de supprimer une evenementsrencontres par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La evenementsrencontres a été supprimé"),
            @ApiResponse(code = 404, message = "Aucune evenementsrencontres n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_evenement_rencontre") Integer id);
}
