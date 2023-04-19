package greta.federation.services;

import greta.federation.dto.CompetitionDto;
import greta.federation.dto.TypeCompetitionDto;

import java.util.List;

public interface TypeCompetitionService {
    TypeCompetitionDto save(TypeCompetitionDto dto);

    TypeCompetitionDto findById(Integer id);

    List<TypeCompetitionDto> findAll();

    void delete(Integer id);

    TypeCompetitionDto update(Integer id, TypeCompetitionDto updatedTypeCompetition);

}