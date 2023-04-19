package greta.federation.controller;

import greta.federation.controller.api.EvenementRencontreApi;
import greta.federation.dto.EvenementRencontreDto;
import greta.federation.services.EvenementRencontreService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EvenementRencontreController implements EvenementRencontreApi {

    private final EvenementRencontreService evenementRencontreService;

    public EvenementRencontreController(EvenementRencontreService evenementRencontreService) {
        this.evenementRencontreService = evenementRencontreService;
    }

    @Override
    public EvenementRencontreDto create(EvenementRencontreDto dto) {
        return this.evenementRencontreService.save(dto);
    }

    @Override
    public EvenementRencontreDto findById(Integer id) {
        return evenementRencontreService.findById(id);
    }

    @Override
    public List<EvenementRencontreDto> findAll() {
        return evenementRencontreService.findAll();
    }

    @Override
    public EvenementRencontreDto update(Integer id, EvenementRencontreDto updatedEvenementRencontre) {
        return evenementRencontreService.update(id, updatedEvenementRencontre);
    }

    @Override
    public void delete(Integer id) {
        evenementRencontreService.delete(id);
    }
}
