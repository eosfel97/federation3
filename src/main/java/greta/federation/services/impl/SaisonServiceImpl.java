package greta.federation.services.impl;

import greta.federation.dto.CompetitionDto;
import greta.federation.dto.SaisonDto;
import greta.federation.entity.Saison;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.repository.SaisonRepository;
import greta.federation.services.SaisonService;
import greta.federation.validator.SaisonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class SaisonServiceImpl implements SaisonService {
    private final SaisonRepository saisonRepository;

    @Autowired
    public SaisonServiceImpl(SaisonRepository saisonRepository) {
        this.saisonRepository = saisonRepository;
    }

    @Override
    public SaisonDto save(SaisonDto dto) {
        List<String> errors = SaisonValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le stade n'est pas valide", ErrorCodes.SAISON_NOT_VALID, errors);
        }

        return SaisonDto.fromEntity(
                saisonRepository.save(
                        SaisonDto.toEntity(dto)
                )
        );
    }


    @Override
    public SaisonDto findById(Integer id) {
        Saison saison = saisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException( "Aucune saision avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.SAISON_NOT_FOUND));
        return SaisonDto.fromEntity(saison);
    }

    @Override
    public List<SaisonDto> findAll() {
        return saisonRepository.findAll().stream()
                .map(SaisonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SaisonDto update(Integer id, SaisonDto updatedSaison) {
        Saison existingSaison = saisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Saison not found with ID: " + id));
        existingSaison.setAnnee(updatedSaison.getAnnee());
        existingSaison.setCompetition(CompetitionDto.toEntity(updatedSaison.getCompetition()));
        existingSaison.setMeilleurButeur(updatedSaison.getMeilleurButeur());
        existingSaison.setNbBut(updatedSaison.getNbBut());
        existingSaison.setNbEncaisse(updatedSaison.getNbEncaisse());
        existingSaison.setMeilleurJoueur(updatedSaison.getMeilleurJoueur());
        existingSaison.setNbCartonJaune(updatedSaison.getNbCartonJaune());
        existingSaison.setNbCartonRouge(updatedSaison.getNbCartonRouge());
        existingSaison.setMeilleurGardien(updatedSaison.getMeilleurGardien());
        saisonRepository.save(existingSaison);
        return SaisonDto.fromEntity(existingSaison);
    }

    @Override
    public void delete(Integer id) {
        saisonRepository.deleteById(id);
    }

}
