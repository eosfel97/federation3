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
    public List<PlaceDto> findByLigne(String nom) {
        return placeService.findByLigne(nom);
    }


    @Override
    public List<PlaceDto> findAll() {
        return placeService.findAll();
    }
    @Override
    public PlaceDto findById(Integer id) {
        return placeService.findById(id);
    }

    @Override
    public void delete(Integer id) {
        placeService.delete(id);
    }
}
