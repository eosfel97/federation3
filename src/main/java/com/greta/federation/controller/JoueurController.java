package com.greta.federation.controller;


import com.greta.federation.controller.api.JoueurApi;
import com.greta.federation.dto.JoueurDto;
import com.greta.federation.services.JoueurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoueurController implements JoueurApi {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @Override
    public JoueurDto save(JoueurDto joueurDto) {
        return joueurService.save(joueurDto);
    }

    @Override
    public JoueurDto findById(Integer id) {
        return joueurService.findById(id);
    }

    @Override
    public List<JoueurDto> findAll() {
        return joueurService.findAll();
    }

    @Override
    public JoueurDto update(Integer id, JoueurDto joueurDto) {
        return joueurService.update(id, joueurDto);
    }

    @Override
    public void delete(Integer id) {
        joueurService.delete(id);
    }
}
