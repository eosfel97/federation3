package com.greta.federation.controller.api;

import com.greta.federation.dto.BilletDto;
import com.greta.federation.dto.UserDto;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/billets")
public interface BilletApi {

    @PostMapping(value = Constants.ADMIN_ENDPOINT + "/billets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un billet", notes = "Cette methode permet d'enregistrer ou modifier un billet", response = BilletDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet billet a été créer ou modifier"),
            @ApiResponse(code = 400, message = "L'objet billet n'est pas valide")
    })
    BilletDto save(@RequestBody BilletDto dto, UserDto userDto);

    @GetMapping(value = Constants.APP_ROOT + "/billets/{id_billet}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un billet par ID", notes = "Cette methode permet de chercher un billet par son ID", response = BilletDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le billet a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun billet n'existe dans la BDD avec l'ID fourni")
    })
    BilletDto findById(@PathVariable("id_billet") Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/billets/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des billets", notes = "Cette methode permet de chercher et renvoyer la liste des billets qui existent "
            + "dans la BDD", responseContainer = "List<BilletDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des billets / Une liste vide")
    })
    List<BilletDto> findAll();

    @DeleteMapping(value = Constants.ADMIN_ENDPOINT + "/billets/{id_billet}")
    @ApiOperation(value = "Supprimer un billet", notes = "Cette methode permet de supprimer un billet par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le billet a ete supprime")
    })
    void delete(@PathVariable("id_billet") Integer id);
}
