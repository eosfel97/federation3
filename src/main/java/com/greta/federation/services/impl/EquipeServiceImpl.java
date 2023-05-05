package com.greta.federation.services.impl;

import com.greta.federation.entity.Equipe;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.EquipeService;
import com.greta.federation.dto.EquipeDto;
import com.greta.federation.repository.EquipeRepository;
import com.greta.federation.validator.EquipeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;


    @Override
    public EquipeDto save(EquipeDto dto) {
        List<String> errors = EquipeValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Equipe is not valid {}", dto);
            throw new InvalidEntityException("l'Equipe n'est pas valide", ErrorCodes.EQUIPE_NOT_VALID, errors);
        }

        return EquipeDto.fromEntity(
                equipeRepository.save(
                        EquipeDto.toEntity(dto)
                )
        );
    }

    @Override
    public EquipeDto findById(Integer id) {
        if (id == null) {
            log.error("Equipe ID is null");
            return null;
        }
        return equipeRepository.findById(id).map(EquipeDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune Equipe avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.EQUIPE_NOT_FOUND)
        );
    }

    @Override
    public EquipeDto findByNom(String nom) {
        Equipe equipe = equipeRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException( "Aucun club avec le Nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.EQUIPE_NOT_FOUND));
        return EquipeDto.fromEntity(equipe);
    }

    @Override
    public List<EquipeDto> findAll() {
        return equipeRepository.findAll().stream()
                .map(EquipeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipe not found with id: " + id));
        equipeRepository.delete(equipe);
    }
}
