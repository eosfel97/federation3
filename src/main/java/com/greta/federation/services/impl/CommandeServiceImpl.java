package com.greta.federation.services.impl;

import com.greta.federation.dto.ArticleDto;
import com.greta.federation.dto.CommandeDto;
import com.greta.federation.dto.LigneCommandeDto;
import com.greta.federation.dto.UserDto;
import com.greta.federation.entity.Article;
import com.greta.federation.entity.Commande;
import com.greta.federation.entity.LigneCommande;
import com.greta.federation.entity.User;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.exception.InvalidOperationException;
import com.greta.federation.repository.ArticleRepository;
import com.greta.federation.repository.LigneCommandeRepository;
import com.greta.federation.services.CommandeService;
import com.greta.federation.validator.CommandeValidator;
import com.greta.federation.repository.CommandeRepository;
import com.greta.federation.repository.UserRepository;
import com.greta.federation.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CommandeServiceImpl  implements CommandeService {
    private final CommandeRepository commandeRepository;
    private  final LigneCommandeRepository ligneCommandeRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;


    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository,UserRepository userRepository, ArticleRepository articleRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeDto save(CommandeDto dto) {

        List<String> errors = CommandeValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_NOT_VALID, errors);
        }

        Optional<User> client = userRepository.findById(dto.getUser().getId());
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.getUser().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getUser().getId() + " n'a ete trouve dans la BDD", ErrorCodes.UTILISATEUR_NOT_FOUND);
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
                    articleErrors.add("Impossible d'enregistrer une commande avec un article NULL");
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
                ligneCommandeRepository.save(ligneCommande);  // Sauvegarde chaque LigneCommande en base de données
                savedCmdClt.getLigneCommandes().add(ligneCommande); // Ajoute chaque LigneCommande à la liste de LigneCommande de la Commande
            });
        }
        return CommandeDto.fromEntity(savedCmdClt);
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
    public List<CommandeDto> findAll() {
        return commandeRepository.findAll().stream()
                .map(CommandeDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return;
        }
        List<LigneCommande> ligneCommandeClients = ligneCommandeRepository.findAllByCommandeId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une commande client deja utilisee",
                    ErrorCodes.COMMANDE_ALREADY_IN_USE);
        }
        commandeRepository.deleteById(id);
    }

}

