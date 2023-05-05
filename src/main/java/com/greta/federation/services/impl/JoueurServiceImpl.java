package com.greta.federation.services.impl;

import com.greta.federation.dto.EvenementRencontreDto;
import com.greta.federation.dto.PosteDto;
import com.greta.federation.entity.Joueur;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.JoueurService;
import com.greta.federation.dto.EquipeDto;
import com.greta.federation.dto.JoueurDto;
import com.greta.federation.repository.JoueurRepository;
import com.greta.federation.validator.JoueurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JoueurServiceImpl implements JoueurService {

    @Autowired
    private  final  JoueurRepository joueurRepository;

    @Autowired
    public JoueurServiceImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Override
    public JoueurDto save(JoueurDto dto) {
        List<String> errors = JoueurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Joueur is not valid {}", dto);
            throw new InvalidEntityException("le Joueur n'est pas valide", ErrorCodes.JOUEUR_NOT_VALID, errors);
        }

        return JoueurDto.fromEntity(
                joueurRepository.save(
                        JoueurDto.toEntity(dto)
                )
        );
    }

    @Override
    public JoueurDto findById(Integer id) {
        if (id == null) {
            log.error("Joueur ID is null");
            return null;
        }
        return joueurRepository.findById(id).map(JoueurDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun joueur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.JOUEUR_NOT_FOUND)
        );
    }

    @Override
    public JoueurDto update(Integer id, JoueurDto updatedJoueur) {
        Joueur existingJoueur = joueurRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Joueur not found with ID: " + id));

        existingJoueur.setNom(updatedJoueur.getNom());
        existingJoueur.setPrenom(updatedJoueur.getPrenom());
        existingJoueur.setPoids(updatedJoueur.getPoids());
        existingJoueur.setTaille(updatedJoueur.getTaille());
        existingJoueur.setNbBut(updatedJoueur.getNbBut());
        existingJoueur.setNbPasseDecisive(updatedJoueur.getNbPasseDecisive());
        existingJoueur.setNbCartonJaune(updatedJoueur.getNbCartonJaune());
        existingJoueur.setNbCartonRouge(updatedJoueur.getNbCartonRouge());
        existingJoueur.setNbButEncaisse(updatedJoueur.getNbButEncaisse());
        existingJoueur.setPoste(PosteDto.toEntity(updatedJoueur.getPoste())); // Correction ici
        existingJoueur.setEquipe(EquipeDto.toEntity(updatedJoueur.getEquipe())); // Correction ici
        existingJoueur.setEvenementRencontre(EvenementRencontreDto.toEntity(updatedJoueur.getEvenementRencontre())); // Correction ici
        joueurRepository.save(existingJoueur);
        return JoueurDto.fromEntity(existingJoueur);
    }


    @Override
    public JoueurDto findByNom(String nom) {
        Joueur joueur = joueurRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException( "Aucun joueur avec le Nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.JOUEUR_NOT_FOUND));
        return JoueurDto.fromEntity(joueur);
    }

    @Override
    public List<JoueurDto> findAll() {
        return joueurRepository.findAll().stream()
                .map(JoueurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Joueur joueur = joueurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Joueur not found with id: " + id));
        joueurRepository.delete(joueur);
    }
}

