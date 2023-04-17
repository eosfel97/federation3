package greta.federation.controller.api;

import greta.federation.dto.ClubDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.*;

@Api("/clubs")
public interface ClubApi {

    @PostMapping(value = DIRECTEUR_ENDPOINT + "/clubs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer un club", notes = "Cette méthode permet de créer ou mettre à jour un club", response = ClubDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet club a été créé ou mis à jour"),
            @ApiResponse(code = 400, message = "L'objet club n'est pas valide")
    })
    ClubDto save(@RequestBody ClubDto dto);

    @PutMapping(value = DIRECTEUR_ENDPOINT + "/clubs/update/{id_club}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un club", notes = "Cette méthode permet de mettre à jour un club existant", response = ClubDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le club a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet club n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucun club n'existe dans la base de données avec l'ID fourni")
    })
    ClubDto update(@PathVariable("id_club") Integer id, @RequestBody ClubDto updatedClub);

    @GetMapping(value = ADMIN_ENDPOINT + "/clubs/{id_club}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un club par ID", notes = "Cette méthode permet de rechercher un club par son ID", response = ClubDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le club a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucun club n'existe dans la base de données avec l'ID fourni")
    })
    ClubDto findById(@PathVariable("id_club") Integer id);

    @GetMapping(value = APP_ROOT + "/clubs/filter/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un club par nom", notes = "Cette méthode permet de rechercher un club par son nom", response = ClubDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le club a été trouvé dans la base de données"),
            @ApiResponse(code = 404, message = "Aucun club n'existe dans la base de données avec le nom fourni")
    })
    ClubDto findByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT + "/clubs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des clubs", notes = "Cette méthode permet de rechercher et renvoyer la liste des clubs qui existent dans la base de données", responseContainer = "List<ClubDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des clubs / Une liste vide")
    })
    List<ClubDto> findAll();

    @DeleteMapping(value = ADMIN_ENDPOINT + "/clubs/delete/{id_club}")
    @ApiOperation(value = "Supprimer un club", notes = "Cette méthode permet de supprimer un club par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le club a été supprimé"),
            @ApiResponse(code = 404, message = "Aucun club n'existe dans la base de données avec l'ID fourni")
    })
    void delete(@PathVariable("id_club") Integer id);
}

