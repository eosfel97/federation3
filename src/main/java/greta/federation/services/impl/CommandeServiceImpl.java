package greta.federation.services.impl;

import greta.federation.dto.ArticleDto;
import greta.federation.dto.CommandeDto;
import greta.federation.dto.LigneCommandeDto;
import greta.federation.entity.Article;
import greta.federation.entity.Commande;
import greta.federation.entity.LigneCommande;
import greta.federation.entity.User;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.exception.InvalidOperationException;
import greta.federation.repository.ArticleRepository;
import greta.federation.repository.CommandeRepository;
import greta.federation.repository.LigneCommandeRepository;
import greta.federation.repository.UserRepository;
import greta.federation.services.CommandeService;
import greta.federation.validator.CommandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CommandeServiceImpl  implements CommandeService{
    private CommandeRepository commandeRepository;
    private LigneCommandeRepository ligneCommandeRepository;
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private CommandeService commandeService;

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository,UserRepository userRepository, ArticleRepository articleRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.commandeService = commandeService;
    }

    @Override
    public CommandeDto save(CommandeDto dto) {

        List<String> errors = CommandeValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_NOT_VALID, errors);
        }

        if (dto.getId() != null && dto.isCommandeLivree()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }

        Optional<User> client = userRepository.findById(dto.getUser().getId());
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.getUser().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getUser().getId() + " n'a ete trouve dans la BDD",
                    ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandes() != null) {
            dto.getLigneCommandes().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligCmdClt.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        dto.setDateCommande(LocalDateTime.now());
        Commande savedCmdClt = commandeRepository.save(CommandeDto.toEntity(dto));

        if (dto.getLigneCommandes() != null) {
            dto.getLigneCommandes().forEach(ligCmdClt -> {
                LigneCommande ligneCommande = LigneCommandeDto.toEntity(ligCmdClt);
                ligneCommande.setCommande(savedCmdClt);
                LigneCommande savedLigneCmd = ligneCommandeRepository.save(ligneCommande);

            });
        }

        return CommandeDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return null;
    }

    @Override
    public CommandeDto updateClient(Integer idCommande, Integer idClient) {
        return null;
    }

    @Override
    public CommandeDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle) {
        return null;
    }


    @Override
    public CommandeDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);

        CommandeDto commandeClient = checkEtatCommande(idCommande);
        // Just to check the LigneCommandeClient and inform the client in case it is absent
        findLigneCommande(idLigneCommande);
        ligneCommandeRepository.deleteById(idLigneCommande);

        return commandeClient;
    }

    private Optional<LigneCommande> findLigneCommande(Integer idLigneCommande) {
        Optional<LigneCommande> ligneCommandeClientOptional = ligneCommandeRepository.findById(idLigneCommande);
        if (ligneCommandeClientOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune ligne commande client n'a ete trouve avec l'ID " + idLigneCommande, ErrorCodes.COMMANDE_NOT_FOUND);
        }
        return ligneCommandeClientOptional;
    }
    private void checkIdCommande(Integer idCommande) {
        if (idCommande == null) {
            log.error("Commande client ID is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un ID null",
                    ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
    }
    private void checkIdLigneCommande(Integer idLigneCommande) {
        if (idLigneCommande == null) {
            log.error("L'ID de la ligne commande is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec une ligne de commande null",
                    ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
    }
    private void checkIdArticle(Integer idArticle, String msg) {
        if (idArticle == null) {
            log.error("L'ID de " + msg + " is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un " + msg + " ID article null",
                    ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
    }
    private CommandeDto checkEtatCommande(Integer idCommande) {
        CommandeDto commande = findById(idCommande);
        if (commande.isCommandeLivree()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
        return commande;
    }
    @Override
    public CommandeDto findById(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeRepository.findById(id)
                .map(CommandeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_NOT_FOUND
                ));
    }

    @Override
    public CommandeDto findByDateCommande(LocalDateTime dateCommande) {
        return null;
    }

    @Override
    public List<CommandeDto> findAll() {
        return null;
    }

    @Override
    public List<LigneCommandeDto> findAllLignesCommandesByCommandeId(Integer idCommande) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

}

