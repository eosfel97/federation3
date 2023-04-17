package greta.federation.controller.api;

import greta.federation.dto.EquipeDto;
import greta.federation.dto.StadeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.*;

@Api("/equipes")
public interface EquipeApi {

    @PostMapping(value = DIRECTEUR_ENDPOINT + "/equipes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer une équipe", notes = "Cette méthode permet de créer ou mettre à jour une équipe", response = EquipeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet équipe a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet équipe n'est pas valide")
    })
    EquipeDto save(@RequestBody EquipeDto dto);

    @GetMapping(value = ADMIN_ENDPOINT+ "/equipes/{id_equipe}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une équipe par ID", notes = "Cette méthode permet de rechercher une équipe par son ID", response = EquipeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'équipe a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucune équipe n'existe dans la base de données avec l'ID fourni")
    })
    EquipeDto findById(@PathVariable("id_equipe") Integer id);


    @GetMapping(value = APP_ROOT + "/equipes/filter/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un stade par nom", notes = "Cette méthode permet de chercher un stade par son nom", response = StadeDto.class)
    EquipeDto findByNom(@PathVariable("nom") String nom);


    @GetMapping(value = APP_ROOT +"/equipes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des équipes", notes = "Cette méthode permet de rechercher et renvoyer la liste des équipes qui existent dans la base de données", responseContainer = "List<EquipeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des équipes / Une liste vide")
    })
    List<EquipeDto> findAll();


    @DeleteMapping(value = DIRECTEUR_ENDPOINT+ "/equipes/delete/{id_equipe}")
    @ApiOperation(value = "Supprimer une équipe", notes = "Cette méthode permet de supprimer une équipe par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'équipe a été supprimée"),
            @ApiResponse(code = 404, message = "Aucune équipe n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_equipe") Integer id);
}
