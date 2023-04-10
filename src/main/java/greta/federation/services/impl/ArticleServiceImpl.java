package greta.federation.services.impl;

import greta.federation.dto.ArticleDto;
import greta.federation.dto.CategorieDto;
import greta.federation.dto.LigneCommandeDto;
import greta.federation.entity.Article;
import greta.federation.entity.LigneCommande;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.exception.InvalidOperationException;
import greta.federation.repository.ArticleRepository;
import greta.federation.repository.LigneCommandeRepository;
import greta.federation.services.ArticleService;
import greta.federation.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;


@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private LigneCommandeRepository commandeRepository;
    @Autowired
    public ArticleServiceImpl( ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        );
    }
    @Override
    public ArticleDto update(Integer id, ArticleDto updatedArticle) {

        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));

        existingArticle.setNom(updatedArticle.getNom());
        existingArticle.setDescription(updatedArticle.getDescription());
        existingArticle.setPrix(updatedArticle.getPrix());
        existingArticle.setQuantite(updatedArticle.getQuantite());
        existingArticle.setCategorie(CategorieDto.toEntity(updatedArticle.getCategorie()));
        ArticleDto existingArticleDto = ArticleDto.fromEntity(existingArticle);
        return save(existingArticleDto);
    }



    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Article Name is null");
            return null;
        }

        return articleRepository.findByNom(nom)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le Nom = " + nom + " n' ete trouve dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<LigneCommandeDto> findHistoriqueCommandeUser(Integer idArticle) {
        return commandeRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public List<ArticleDto> findAllArticleByIdCategorie(Integer id_categorie) {
        return articleRepository.findAllByCategorieId(id_categorie).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
       // List<LigneCommande> ligneCommande = commandeRepository.findAllByArticleId(id);
       /* if (!ligneCommande.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }*/
        articleRepository.deleteById(id);
    }
}
