package com.greta.federation.services.impl;

import com.greta.federation.dto.LigneDto;
import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Place;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.repository.LigneRepository;
import com.greta.federation.services.LigneService;
import com.greta.federation.validator.LigneValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LigneServiceImpl implements LigneService {

    private final LigneRepository ligneRepository;

    @Autowired
    public LigneServiceImpl(LigneRepository ligneRepository) {
        this.ligneRepository = ligneRepository;
    }

    @Override
    public LigneDto save(LigneDto dto) {
        List<String> errors = LigneValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La ligne n'est pas valide {}", dto);
            throw new InvalidEntityException("La ligne n'est pas valide", ErrorCodes.LIGNE_NOT_VALID, errors);
        }

        return LigneDto.fromEntity(
                ligneRepository.save(
                        LigneDto.toEntity(dto)
                )
        );
    }

    @Override
    public LigneDto findById(Integer id) {
        Ligne ligne = ligneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucune ligne avec l'ID = " + id + " n'a été trouvée dans la base de données",
                        ErrorCodes.LIGNE_NOT_FOUND));
        return LigneDto.fromEntity(ligne);
    }

    @Override
    public List<LigneDto> findAll() {
        return ligneRepository.findAll()
                .stream()
                .map(LigneDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<String> findPlaceNomByLigneId(Integer id) {
        Optional<Ligne> stadeOptional = ligneRepository.findById(id);

        if(stadeOptional.isPresent()){
            Ligne ligne = stadeOptional.get();
            List<Place> places = ligne.getPlaces();
            if (places != null && !places.isEmpty()) {
                return places.stream()
                        .map(Place::getNom)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    @Override
    public LigneDto findByNom(String nom) {
        Ligne ligne = ligneRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException( "Aucune aile avec le Nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.AILE_NOT_FOUND));
        return LigneDto.fromEntity(ligne);
    }


    @Override
    public void delete(Integer id) {
        ligneRepository.deleteById(id);
    }
}
