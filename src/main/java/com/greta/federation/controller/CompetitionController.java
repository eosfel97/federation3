package com.greta.federation.controller;
import com.greta.federation.controller.api.CompetitionApi;
import com.greta.federation.dto.CompetitionDto;
import com.greta.federation.services.CompetitionService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CompetitionController implements CompetitionApi {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @Override
    public CompetitionDto create(CompetitionDto dto) {
        return this.competitionService.save(dto);
    }

    @Override
    public List<CompetitionDto> findAll() {
        return competitionService.findAll();
    }

    @Override
    public CompetitionDto findById(Integer id) {
        return competitionService.findById(id);
    }

    @Override
    public CompetitionDto update(Integer id, CompetitionDto updatedCCompetition) {
        return competitionService.update(id, updatedCCompetition);
    }

    @Override
    public void delete(Integer id) {
        competitionService.delete(id);
    }
}