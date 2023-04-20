package com.greta.federation.services;

import com.greta.federation.dto.CategorieFootballDto;

import java.util.List;

public interface CategorieFootballService {
    CategorieFootballDto save(CategorieFootballDto dto);

    CategorieFootballDto update(Integer id, CategorieFootballDto updatedCategorieFootball);

    CategorieFootballDto findById(Integer id);

    List<CategorieFootballDto> findAll();

    void delete(Integer id);
}
