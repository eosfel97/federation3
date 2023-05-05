package com.greta.federation.services;

import com.greta.federation.dto.CompetitionDto;

import java.util.List;

public interface CompetitionService {
    CompetitionDto save(CompetitionDto dto);
    CompetitionDto findById(Integer id);
    List<CompetitionDto> findAll();
    void delete(Integer id);
    CompetitionDto update(Integer id, CompetitionDto dto); // New update method
}