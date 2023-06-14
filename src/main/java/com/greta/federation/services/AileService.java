package com.greta.federation.services;

import com.greta.federation.dto.AileDto;

import java.util.List;

public interface AileService {
    AileDto save(AileDto dto);
    AileDto findById(Integer id);
    List<AileDto> findAll();
    List<String> findLigneNomByAileId(Integer aileId);
    void delete(Integer id);

    AileDto findByNom(String nom);
}
