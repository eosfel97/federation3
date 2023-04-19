package greta.federation.services.impl;

import greta.federation.dto.CategorieFootballDto;
import greta.federation.dto.ClubDto;
import greta.federation.dto.CompetitionDto;
import greta.federation.dto.TypeCompetitionDto;
import greta.federation.entity.Club;
import greta.federation.entity.Competition;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.repository.CompetitionRepository;
import greta.federation.services.CompetitionService;
import greta.federation.validator.CompetitionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public CompetitionDto save(CompetitionDto dto) {
        List<String> errors = CompetitionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Club is not valid {}", dto);
            throw new InvalidEntityException("le Club n'est pas valide", ErrorCodes.COMPETITION_NOT_VALID, errors);
        }

        return CompetitionDto.fromEntity(
                competitionRepository.save(
                        CompetitionDto.toEntity(dto)
                )
        );
    }

    @Override
    public CompetitionDto findById(Integer id) {
        if (id == null) {
            log.error("Club ID is null");
            return null;
        }
        return competitionRepository.findById(id).map(CompetitionDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune Competition avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.COMPETITION_NOT_FOUND)
        );
    }
    @Override
    public List<CompetitionDto> findAll() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(CompetitionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("competition not found with id: " + id));
        competitionRepository.delete(competition);
    }
    @Override
    public CompetitionDto update(Integer id, CompetitionDto updatedCompetition) {
        Competition existingCompetition= competitionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + id));

        existingCompetition.setNom(updatedCompetition.getNom());
        existingCompetition.setTypeCompetition(TypeCompetitionDto.toEntity(updatedCompetition.getTypeCompetition()));
        existingCompetition.setCategorieFootball(CategorieFootballDto.toEntity(updatedCompetition.getCategorieFootball()));
            competitionRepository.save(existingCompetition);
        return CompetitionDto.fromEntity(existingCompetition);
    }
}