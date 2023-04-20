package com.greta.federation.services.impl;

import com.greta.federation.dto.CompetitionDto;
import com.greta.federation.dto.RencontreDto;
import com.greta.federation.entity.Rencontre;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.repository.RencontreRepository;
import com.greta.federation.services.RencontreService;
import com.greta.federation.validator.RencontreValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RencontreServiceImpl implements RencontreService {
    private final RencontreRepository rencontreRepository;

    @Autowired
    public RencontreServiceImpl(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    @Override
    public RencontreDto create(RencontreDto dto) {
        List<String> errors = RencontreValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Rencontre is not valid {}", dto);
            throw new InvalidEntityException("La rencontre n'est pas valide", ErrorCodes.RENCONTRE_NOT_VALID, errors);
        }

        return RencontreDto.fromEntity(
                rencontreRepository.save(
                        RencontreDto.toEntity(dto)
                )
        );
    }

    @Override
    public RencontreDto findById(Integer id) {
        if (id == null) {
            log.error("Rencontre ID is null");
            return null;
        }
        return rencontreRepository.findById(id).map(RencontreDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune rencontre avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.RENCONTRE_NOT_FOUND)
        );
    }

    @Override
    public List<RencontreDto> findAll() {
        List<Rencontre> rencontres = rencontreRepository.findAll();
        return rencontres.stream()
                .map(RencontreDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Rencontre rencontre = rencontreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rencontre not found with id: " + id));
        rencontreRepository.delete(rencontre);
    }

    @Override
    public RencontreDto update(Integer id, RencontreDto updatedRencontre) {
        Rencontre existingRencontre = rencontreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rencontre not found with ID: " + id));

        existingRencontre.setNbButDomicile(updatedRencontre.getNbButDomicile());
        existingRencontre.setNbButExterieur(updatedRencontre.getNbButExterieur());
        existingRencontre.setCompetition(CompetitionDto.toEntity(updatedRencontre.getCompetition()));
        rencontreRepository.save(existingRencontre);
        return RencontreDto.fromEntity(existingRencontre);
    }
}
