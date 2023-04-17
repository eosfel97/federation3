package greta.federation.controller;

import greta.federation.controller.api.ArbitreApi;
import greta.federation.dto.ArbitreDto;
import greta.federation.services.ArbitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArbitreController implements ArbitreApi {

    private final ArbitreService arbitreService;

    @Autowired
    public ArbitreController(ArbitreService arbitreService) {
        this.arbitreService = arbitreService;
    }

    @Override
    public ArbitreDto save(ArbitreDto dto) {
        return arbitreService.save(dto);
    }

    @Override
    public ArbitreDto findById(Integer id) {
        return arbitreService.findById(id);
    }

    @Override
    public List<ArbitreDto> findAll() {
        return arbitreService.findAll();
    }

    @Override
    public void delete(Integer id) {
        arbitreService.delete(id);
    }
}

