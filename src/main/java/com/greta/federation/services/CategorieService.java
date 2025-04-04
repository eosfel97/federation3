package com.greta.federation.services;

import com.greta.federation.dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto save(CategorieDto dto);

    CategorieDto findById(Integer id);

    CategorieDto findByNom(String code);

    List<CategorieDto> findAll();

    void delete(Integer id);
}
