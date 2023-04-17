package greta.federation.services.impl;

import greta.federation.dto.ActualiteDto;
import greta.federation.dto.ArticleDto;
import greta.federation.dto.CategorieDto;
import greta.federation.entity.Actualite;
import greta.federation.entity.Article;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.repository.ActualiteRepository;
import greta.federation.services.ActualiteService;
import greta.federation.validator.ActualiteValidator;
import greta.federation.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActualiteServiceImpl implements ActualiteService {
    @Autowired
    private ActualiteRepository actualiteRepository;

    public ActualiteServiceImpl(ActualiteRepository actualiteRepository) {
        this.actualiteRepository = actualiteRepository;
    }

    @Override
    public ActualiteDto save(ActualiteDto dto) {
        List<String> errors = ActualiteValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Actualite is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ACTUALITE_NOT_FOUND, errors);
        }

        return ActualiteDto.fromEntity(
                actualiteRepository.save(
                        ActualiteDto.toEntity(dto)
                )
        );
    }

    @Override
    public ActualiteDto update(Integer id, ActualiteDto updatedActualite) {

        Actualite existingActualite = actualiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actualite not found with id " + id));

        existingActualite.setTitre(updatedActualite.getTitre());
        existingActualite.setInformation(updatedActualite.getInformation());
        ActualiteDto existingActualiteDto = ActualiteDto.fromEntity(existingActualite);
        return save(existingActualiteDto);
    }

    @Override
    public ActualiteDto findById(Integer id) {
        if (id == null) {
            log.error("Actualite ID is null");
            return null;
        }

        return actualiteRepository.findById(id).map(ActualiteDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune actualite avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ACTUALITE_NOT_FOUND)
        );
    }


    @Override
    public ActualiteDto findByTitre(String titre) {
        if (!StringUtils.hasLength(titre)) {
            log.error("Actualite titre is null");
            return null;
        }

        return actualiteRepository.findByTitre(titre)
                .map(ActualiteDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucune actualite avec le titre = " + titre + " n' ete trouve dans la BDD",
                                ErrorCodes.ACTUALITE_NOT_FOUND)
                );
    }



    @Override
    public List<ActualiteDto>  findAll() {
        return actualiteRepository.findAll().stream()
                .map(ActualiteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Actualite ID is null");
            return;
        }
        actualiteRepository.deleteById(id);
    }
}
