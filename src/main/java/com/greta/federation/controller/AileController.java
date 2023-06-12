package com.greta.federation.controller;

import com.greta.federation.controller.api.AileApi;
import com.greta.federation.services.AileService;

import com.greta.federation.dto.AileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AileController implements AileApi {

    private final AileService aileService;

    @Autowired
    public AileController(AileService aileService) {
        this.aileService = aileService;
    }

    @Override
    public AileDto save(AileDto dto) {
        return aileService.save(dto);
    }

    @Override
    public AileDto findById(Integer id) {
        return aileService.findById(id);
    }

    @Override
    public AileDto findByNom(String nom) {
        return aileService.findByNom(nom);
    }
    @Override
    public List<AileDto> findAll() {
        return aileService.findAll();
    }

    @Override
    public void delete(Integer id) {
        aileService.delete(id);
    }
}
