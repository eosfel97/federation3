package com.greta.federation.services.impl;

import com.greta.federation.dto.TypeCompetitionDto;
import com.greta.federation.entity.TypeCompetition;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.repository.TypeCompetitionRepository;
import com.greta.federation.services.TypeCompetitionService;
import com.greta.federation.validator.TypeCompetitionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TypeCompetitionServiceImpl implements TypeCompetitionService {
    @Autowired
    private TypeCompetitionRepository typeCompetitionRepository;

    @Override
    public TypeCompetitionDto save(TypeCompetitionDto dto) {
        List<String> errors = TypeCompetitionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("TypeCompetition is not valid {}", dto);
            throw new InvalidEntityException("le Club n'est pas valide", ErrorCodes.TYPECOMPETITION_NOT_VALID, errors);
        }

        return TypeCompetitionDto.fromEntity(
                typeCompetitionRepository.save(
                        TypeCompetitionDto.toEntity(dto)
                )
        );
    }
    @Override
    public TypeCompetitionDto findById(Integer id) {
        if (id == null) {
            log.error("Club ID is null");
            return null;
        }
        return typeCompetitionRepository.findById(id).map(TypeCompetitionDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune TypeCompetition avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.TYPECOMPETITION_NOT_FOUND)
        );
    }

    @Override
    public List<TypeCompetitionDto> findAll() {
        List<TypeCompetition> TypeCompetitions = typeCompetitionRepository.findAll();
        return TypeCompetitions.stream()
                .map(TypeCompetitionDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {
        TypeCompetition typeCompetition = typeCompetitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("typeCompetition not found with id: " + id));
        typeCompetitionRepository.delete(typeCompetition);
    }


    @Override
    public TypeCompetitionDto update(Integer id, TypeCompetitionDto updatedTypeCompetition) {
        TypeCompetition existingTypeCompetition= typeCompetitionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("typeCompetition not found with ID: " + id));

        existingTypeCompetition.setNom(updatedTypeCompetition.getNom());
        typeCompetitionRepository.save(existingTypeCompetition);
        return TypeCompetitionDto.fromEntity(existingTypeCompetition);
    }

}
