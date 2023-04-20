package com.greta.federation.services.impl;


import com.greta.federation.entity.Stade;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.StadeService;
import com.greta.federation.dto.StadeDto;
import com.greta.federation.repository.StadeRepository;
import com.greta.federation.validator.StadeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;



@Service
@Slf4j
public class StadeServiceImpl implements StadeService {

    private final StadeRepository stadeRepository;

    @Autowired
    public StadeServiceImpl(StadeRepository stadeRepository) {
        this.stadeRepository = stadeRepository;
    }

    @Override
    public StadeDto save(StadeDto dto) {
        List<String> errors = StadeValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le stade n'est pas valide", ErrorCodes.STADE_NOT_VALID, errors);
        }

        return StadeDto.fromEntity(
                stadeRepository.save(
                        StadeDto.toEntity(dto)
                )
        );
    }

    @Override
    public StadeDto findById(Integer id) {
        Stade stade = stadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException( "Aucun stade avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.STADE_NOT_FOUND));
        return StadeDto.fromEntity(stade);
    }
    @Override
    public StadeDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Stade Name is null");
            return null;
        }

        return stadeRepository.findByNom(nom)
                .map(StadeDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun stade avec le Nom = " + nom + " n' ete trouve dans la BDD",
                                ErrorCodes.STADE_NOT_FOUND)
                );
    }
    @Override
    public StadeDto update(Integer id, StadeDto updatedStade) {
        Stade existingStade = stadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stade not found with ID: " + id));

        existingStade.setNom(updatedStade.getNom());
        existingStade.setNbPlaces(updatedStade.getNbPlaces());
        existingStade.setTypeTerrain(updatedStade.getTypeTerrain());

        stadeRepository.save(existingStade);
        return StadeDto.fromEntity(existingStade);
    }

    @Override
    public List<StadeDto> findAll() {
        return stadeRepository.findAll()
                .stream()
                .map(StadeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        stadeRepository.deleteById(id);
    }
}
