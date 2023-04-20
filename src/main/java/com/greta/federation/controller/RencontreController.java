package com.greta.federation.controller;

import com.greta.federation.controller.api.RencontreApi;
import com.greta.federation.dto.RencontreDto;
import com.greta.federation.services.RencontreService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RencontreController implements RencontreApi {

    private final RencontreService rencontreService;

    public RencontreController(RencontreService rencontreService) {
        this.rencontreService = rencontreService;
    }

    @Override
    public RencontreDto create(RencontreDto dto) {
        return this.rencontreService.create(dto);
    }

    @Override
    public List<RencontreDto> findAll() {
        return rencontreService.findAll();
    }

    @Override
    public RencontreDto findById(Integer id) {
        return rencontreService.findById(id);
    }

    @Override
    public RencontreDto update(Integer id, RencontreDto updatedRencontre) {
        return rencontreService.update(id, updatedRencontre);
    }

    @Override
    public void delete(Integer id) {
        rencontreService.delete(id);
    }
}

