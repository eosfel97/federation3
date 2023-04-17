package greta.federation.controller;


import greta.federation.controller.api.EquipeApi;
import greta.federation.dto.EquipeDto;
import greta.federation.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeController implements EquipeApi {


    private final EquipeService equipeService;
    
    @Autowired
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @Override
    public EquipeDto save(EquipeDto dto) {
        return equipeService.save(dto);
    }

    @Override
    public EquipeDto findById(Integer id) {
        return equipeService.findById(id);
    }

    @Override
    public EquipeDto findByNom(String nom) {
        return equipeService.findByNom(nom);
    }

    @Override
    public List<EquipeDto> findAll() {
        return equipeService.findAll();
    }


    @Override
    public void delete(Integer id) {
        equipeService.delete(id);
    }

}
