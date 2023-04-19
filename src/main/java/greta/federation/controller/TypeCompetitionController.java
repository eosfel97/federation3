package greta.federation.controller;

import greta.federation.controller.api.TypeCompetitionApi;
import greta.federation.dto.TypeCompetitionDto;
import greta.federation.services.TypeCompetitionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TypeCompetitionController implements TypeCompetitionApi {
    private final TypeCompetitionService typeCompetitionService;
    

    public TypeCompetitionController(TypeCompetitionService typeCompetitionService) {
        this.typeCompetitionService = typeCompetitionService;
    }

    @Override
    public TypeCompetitionDto create(TypeCompetitionDto dto) {
        return this.typeCompetitionService.save(dto);
    }

    @Override
    public List<TypeCompetitionDto> findAll() {
        return typeCompetitionService.findAll();
    }

    @Override
    public TypeCompetitionDto findById(Integer id) {
        return typeCompetitionService.findById(id);
    }

    @Override
    public TypeCompetitionDto update(Integer id, TypeCompetitionDto updatedTypeCompetition) {
        return typeCompetitionService.update(id, updatedTypeCompetition);
    }

    @Override
    public void delete(Integer id) {
        typeCompetitionService.delete(id);
    }
}
