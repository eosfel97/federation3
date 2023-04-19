package greta.federation.controller.api;


import greta.federation.dto.CompetitionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.*;

@Api("/competitions")
public interface  CompetitionApi {


    @PostMapping(value = ADMIN_ENDPOINT + "/competitions/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une competitions", notes = "Cette méthode permet de créer ou mettre à jour une competitions", response = CompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet competitions a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet competitions n'est pas valide")
    })
    CompetitionDto create(@RequestBody CompetitionDto dto);

    @PutMapping(value = ADMIN_ENDPOINT + "/competitions/update/{id_competition}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une competition", notes = "Cette méthode permet de mettre à jour une competitions existant", response = CompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La competitions a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet competitions n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucune competitions n'existe dans la base de données avec l'ID fourni")
    })
    CompetitionDto update(@PathVariable("id_competition") Integer id, @RequestBody CompetitionDto updatedCCompetition);

    @GetMapping(value = ADMIN_ENDPOINT + "/competitions/{id_competition}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une competitions par ID", notes = "Cette méthode permet de rechercher une competitions par son ID", response = CompetitionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La competitions a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune competitions n'existe dans la base de données avec l'ID fourni")
    })
    CompetitionDto findById(@PathVariable("id_competition") Integer id);

    @GetMapping(value = APP_ROOT + "/competitions/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des competitions", notes = "Cette méthode permet de rechercher et renvoyer la liste des competitions qui existent dans la base de données", responseContainer = "List<CompetitionDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des competitions / Une liste vide")
    })
    List<CompetitionDto> findAll();

    @DeleteMapping(value = ADMIN_ENDPOINT + "/competitions/delete/{id_competition}")
    @ApiOperation(value = "Supprimer un competitions", notes = "Cette méthode permet de supprimer une competitions par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La competitions a été supprimé"),
            @ApiResponse(code = 404, message = "Aucune competition n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_competition") Integer id);
}
