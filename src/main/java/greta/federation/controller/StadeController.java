package greta.federation.controller;

import greta.federation.controller.api.StadeApi;
import greta.federation.dto.StadeDto;
import greta.federation.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StadeController implements StadeApi {

    private final StadeService stadeService;

    @Autowired
    public StadeController(StadeService stadeService) {
        this.stadeService = stadeService;
    }

    @Override
    public StadeDto save(StadeDto dto) {
        return stadeService.save(dto);
    }

    @Override
    public StadeDto update(Integer id, StadeDto updatedStade) {
        return stadeService.update(id, updatedStade);
    }

    @Override
    public StadeDto findByNom(String nom) {
        return stadeService.findByNom(nom);
    }

    @Override
    public StadeDto findById(Integer id) {
        return stadeService.findById(id);
    }

    @Override
    public List<StadeDto> findAll() {
        return stadeService.findAll();
    }

    @Override
    public void delete(Integer id) {
        stadeService.delete(id);
    }
}
