package com.greta.federation.services;

import com.greta.federation.dto.SaisonDto;

import java.util.List;

public interface SaisonService {
    SaisonDto save(SaisonDto saisonDto);
    SaisonDto findById(Integer id);
    List<SaisonDto> findAll();
    SaisonDto update(Integer id, SaisonDto updatedSaison);

    void delete(Integer id);
}
