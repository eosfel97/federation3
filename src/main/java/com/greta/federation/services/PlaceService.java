package com.greta.federation.services;

import com.greta.federation.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    PlaceDto save(PlaceDto dto);
    PlaceDto findById(Integer id);
    List<PlaceDto> findAll();

    void delete(Integer id);
    List<PlaceDto> findByLigne(String nom);
}
