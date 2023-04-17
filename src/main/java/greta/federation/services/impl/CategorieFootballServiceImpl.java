package greta.federation.service.impl;

import greta.federation.dto.CategorieFootballDto;
import greta.federation.dto.ClubDto;
import greta.federation.entity.CategorieFootball;
import greta.federation.entity.Club;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.repository.CategorieFootballRepository;
import greta.federation.service.CategorieFootballService;
import greta.federation.validator.CategorieFootballValidator;
import greta.federation.validator.ClubValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieFootballServiceImpl implements CategorieFootballService {

    private final CategorieFootballRepository categorieFootballRepository;

    @Autowired
    public CategorieFootballServiceImpl(CategorieFootballRepository categorieFootballRepository) {
        this.categorieFootballRepository = categorieFootballRepository;
    }

    @Override
    public CategorieFootballDto save(CategorieFootballDto dto) {
        List<String> errors = CategorieFootballValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Club is not valid {}", dto);
            throw new InvalidEntityException("le Club n'est pas valide", ErrorCodes.CATEGORY_FOOTBALL_NOT_VALID, errors);
        }

        return CategorieFootballDto.fromEntity(
                categorieFootballRepository.save(
                        CategorieFootballDto.toEntity(dto)
                )
        );
    }
    @Override
    public CategorieFootballDto update(Integer id, CategorieFootballDto updatedCategorieFootball) {
        CategorieFootball existingCategorie = categorieFootballRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CategorieFootball not found with ID: " + id));

        existingCategorie.setNom(updatedCategorieFootball.getNom());
        existingCategorie.setNbJoueursMaxEquipe(updatedCategorieFootball.getNbJoueursMaxEquipe());
        existingCategorie.setNbRemplacantEquipe(updatedCategorieFootball.getNbRemplacantEquipe());
        existingCategorie.setNbMinuteRencontre(updatedCategorieFootball.getNbMinuteRencontre());
        existingCategorie.setNbMiTempsRencontre(updatedCategorieFootball.getNbMiTempsRencontre());

        categorieFootballRepository.save(existingCategorie);
        return CategorieFootballDto.fromEntity(existingCategorie);
    }

    @Override
    public CategorieFootballDto findById(Integer id) {
        if (id == null) {
            log.error("CategorieFootbal ID is null");
            return null;
        }
        return categorieFootballRepository.findById(id).map(CategorieFootballDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun CategorieFootballDto avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_FOOTBALL_NOT_FOUND)
        );
    }

    @Override
    public List<CategorieFootballDto> findAll() {
        return categorieFootballRepository.findAll().stream()
                .map(CategorieFootballDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        CategorieFootball categorieFootball = categorieFootballRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CategorieFootball not found with id: " + id));
        categorieFootballRepository.delete(categorieFootball);
    }
}
