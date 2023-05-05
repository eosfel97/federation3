package com.greta.federation.services;

import com.greta.federation.dto.ActualiteDto;

import java.util.List;

public interface ActualiteService {

    ActualiteDto save(ActualiteDto dto);
    ActualiteDto update(Integer id, ActualiteDto updatedActualite);
    ActualiteDto findById(Integer id);

    ActualiteDto findByTitre(String titre);

    List<ActualiteDto> findAll();

    void delete(Integer id);

}
