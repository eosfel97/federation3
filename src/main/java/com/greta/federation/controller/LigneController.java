package com.greta.federation.controller;

import com.greta.federation.controller.api.LigneApi;
import com.greta.federation.services.LigneService;

import com.greta.federation.dto.LigneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LigneController implements LigneApi {

    private final LigneService ligneService;

    @Autowired
    public LigneController(LigneService ligneService) {
        this.ligneService = ligneService;
    }

    @Override
    public LigneDto save(LigneDto dto) {
        return ligneService.save(dto);
    }

    @Override
    public LigneDto findById(Integer id) {
        return ligneService.findById(id);
    }

    @Override
    public List<LigneDto> findAll() {
        return ligneService.findAll();
    }
    @Override
    public List<String> findPlaceNomByLigneId(Integer aileId) {
        return ligneService.findPlaceNomByLigneId(aileId);
    }

    @Override
    public void delete(Integer id) {
        ligneService.delete(id);
    }
}
