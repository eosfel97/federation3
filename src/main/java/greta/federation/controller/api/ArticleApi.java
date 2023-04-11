package greta.federation.controller.api;

import greta.federation.dto.ArticleDto;
import greta.federation.dto.LigneCommandeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.ADMIN_ENDPOINT;
import static greta.federation.utils.Constants.APP_ROOT;

@Api("/articles")
public interface ArticleApi {
    @PostMapping(value = ADMIN_ENDPOINT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article a été créer ou modifier"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto dto);
    @PutMapping(value = ADMIN_ENDPOINT + "/articles/update/{id_article}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un article", notes = "Cette méthode permet de mettre à jour un article existant", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a été mis à jour avec succès"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto update(@PathVariable("id_article") Integer id, @RequestBody ArticleDto updatedArticle);
    @GetMapping(value = ADMIN_ENDPOINT + "/articles/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("id_article") Integer id);
    @GetMapping(value = APP_ROOT + "/articles/filter/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par nom", notes = "Cette methode permet de chercher un article par son Nom", response =
            ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le Nom fourni")
    })
    ArticleDto findByNom(@PathVariable("nom") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles qui existent "
            + "dans la BDD", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<ArticleDto> findAll();
    @GetMapping(value = APP_ROOT + "/articles/filter/category/{id_categorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAllArticleByIdCategorie(@PathVariable("id_categorie") Integer id_categorie);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandeuser/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeDto> findHistoriqueCommandeUser(@PathVariable("id_article") Integer id_article);

    @DeleteMapping(value = ADMIN_ENDPOINT + "/articles/delete/{id_article}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprime")
    })
    void delete(@PathVariable("id_article") Integer id);
}
