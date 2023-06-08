package com.greta.federation.services;

import com.greta.federation.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    PlaceDto save(PlaceDto dto);
    PlaceDto findById(Integer id);
    List<PlaceDto> findAll();
    List<PlaceDto> findByAile(String aile);
    List<PlaceDto> findByLigne(String ligne);
    List<PlaceDto> findByNumLigne(String numLigne);
    List<PlaceDto> findByStadeId(Integer idStade);
    void delete(Integer id);
}
