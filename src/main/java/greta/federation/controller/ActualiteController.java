package greta.federation.controller;

import greta.federation.controller.api.ActualiteApi;
import greta.federation.dto.ActualiteDto;
import greta.federation.services.ActualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActualiteController implements ActualiteApi {

    private final ActualiteService actualiteService;

    @Autowired
    public ActualiteController(ActualiteService actualiteService) {
        this.actualiteService = actualiteService;
    }

    @Override
    public ActualiteDto save(ActualiteDto dto) {
        return actualiteService.save(dto);
    }

    @Override
    public ActualiteDto update(Integer id, ActualiteDto updatedActualite) {
        return actualiteService.update(id, updatedActualite);
    }

    @Override
    public ActualiteDto findById(Integer id) {
        return actualiteService.findById(id);
    }

    @Override
    public ActualiteDto findByTitre(String titre) {
        return actualiteService.findByTitre(titre);
    }

    @Override
    public List<ActualiteDto> findAll() {
        return actualiteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        actualiteService.delete(id);
    }
}
