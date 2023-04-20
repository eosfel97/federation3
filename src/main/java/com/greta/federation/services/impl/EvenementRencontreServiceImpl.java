package com.greta.federation.services.impl;

import com.greta.federation.dto.EvenementRencontreDto;
import com.greta.federation.dto.JoueurDto;
import com.greta.federation.dto.RencontreDto;
import com.greta.federation.entity.EvenementRencontre;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.EvenementRencontreService;
import com.greta.federation.repository.EvenementRencontreRepository;
import com.greta.federation.validator.EvenementRencontreValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EvenementRencontreServiceImpl implements EvenementRencontreService {
    private final EvenementRencontreRepository evenementRencontreRepository;

    @Autowired
    public EvenementRencontreServiceImpl(EvenementRencontreRepository evenementRencontreRepository) {
        this.evenementRencontreRepository = evenementRencontreRepository;
    }

    @Override
    public EvenementRencontreDto save(EvenementRencontreDto dto) {
        List<String> errors = EvenementRencontreValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("EvenementRencontre is not valid {}", dto);
            throw new InvalidEntityException("L'EvenementRencontre n'est pas valide", ErrorCodes.EVENEMENT_RENCONTRE_NOT_VALID, errors);
        }

        return EvenementRencontreDto.fromEntity(
                evenementRencontreRepository.save(
                        EvenementRencontreDto.toEntity(dto)
                )
        );
    }

    @Override
    public EvenementRencontreDto findById(Integer id) {
        if (id == null) {
            log.error("EvenementRencontre ID is null");
            return null;
        }
        return evenementRencontreRepository.findById(id).map(EvenementRencontreDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun EvenementRencontre avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.EVENEMENT_RENCONTRE_NOT_FOUND)
        );
    }

    @Override
    public List<EvenementRencontreDto> findAll() {
        List<EvenementRencontre> evenementRencontres = evenementRencontreRepository.findAll();
        return evenementRencontres.stream()
                .map(EvenementRencontreDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        EvenementRencontre evenementRencontre = evenementRencontreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("EvenementRencontre not found with id: " + id));
        evenementRencontreRepository.delete(evenementRencontre);
    }

    @Override
    public EvenementRencontreDto update(Integer id, EvenementRencontreDto updatedEvenementRencontre) {
        EvenementRencontre existingEvenementRencontre = evenementRencontreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EvenementRencontre not found with ID: " + id));

        existingEvenementRencontre.setNom(updatedEvenementRencontre.getNom());
        existingEvenementRencontre.setType(updatedEvenementRencontre.getType());
        existingEvenementRencontre.setJoueur(JoueurDto.toEntity(updatedEvenementRencontre.getJoueur()));
        existingEvenementRencontre.setRencontre(RencontreDto.toEntity(updatedEvenementRencontre.getRencontre()));

        evenementRencontreRepository.save(existingEvenementRencontre);
        return EvenementRencontreDto.fromEntity(existingEvenementRencontre);
    }
}

