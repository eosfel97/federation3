package com.greta.federation.controller;

import com.greta.federation.controller.api.CategorieFootballApi;
import com.greta.federation.dto.CategorieFootballDto;
import com.greta.federation.services.CategorieFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieFootballController implements CategorieFootballApi {

    private final CategorieFootballService categorieFootballService;

    @Autowired
    public CategorieFootballController(CategorieFootballService categorieFootballService) {
        this.categorieFootballService = categorieFootballService;
    }

    @Override
    public CategorieFootballDto save(CategorieFootballDto dto) {
        return categorieFootballService.save(dto);
    }

    @Override
    public CategorieFootballDto update(Integer id, CategorieFootballDto updatedCategorieFootball) {
        return categorieFootballService.update(id, updatedCategorieFootball);
    }

    @Override
    public CategorieFootballDto findById(Integer id) {
        return categorieFootballService.findById(id);
    }

    @Override
    public List<CategorieFootballDto> findAll() {
        return categorieFootballService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categorieFootballService.delete(id);
    }
}
