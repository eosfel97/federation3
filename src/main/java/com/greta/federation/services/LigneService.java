package com.greta.federation.services;

import com.greta.federation.dto.LigneDto;

import java.util.List;

public interface LigneService {
    LigneDto save(LigneDto dto);
    LigneDto findById(Integer id);
    List<LigneDto> findAll();

    void delete(Integer id);
}
