package com.greta.federation.services;

import com.greta.federation.dto.AileDto;
import com.greta.federation.dto.ClubDto;

import java.util.List;

public interface AileService {
    AileDto save(AileDto dto);
    AileDto findById(Integer id);
    List<AileDto> findAll();

    void delete(Integer id);

    AileDto findByNom(String nom);
}
