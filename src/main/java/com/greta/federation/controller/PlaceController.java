package com.greta.federation.controller;

import com.greta.federation.services.PlaceService;
import com.greta.federation.controller.api.PlaceApi;
import com.greta.federation.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController implements PlaceApi {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public PlaceDto save(PlaceDto dto) {
        return placeService.save(dto);
    }

    @Override
    public List<PlaceDto> findByAile(String aile) {
        return placeService.findByAile(aile);
    }

    @Override
    public List<PlaceDto> findByLigne(String ligne) {
        return placeService.findByLigne(ligne);
    }

    @Override
    public List<PlaceDto> findByNumLigne(String numLigne) {
        return placeService.findByNumLigne(numLigne);
    }

    @Override
    public List<PlaceDto> findByStadeId(Integer idStade) {
        return placeService.findByStadeId(idStade);
    }

    @Override
    public List<PlaceDto> findAll() {
        return placeService.findAll();
    }

    @Override
    public void delete(Integer id) {
        placeService.delete(id);
    }
}
