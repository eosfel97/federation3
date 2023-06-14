package com.greta.federation.services.impl;

import com.greta.federation.dto.AileDto;
import com.greta.federation.dto.ClubDto;
import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Club;
import com.greta.federation.entity.Ligne;
import com.greta.federation.entity.Stade;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.repository.AileRepository;
import com.greta.federation.services.AileService;
import com.greta.federation.validator.AileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AileServiceImpl implements AileService {

    private final AileRepository aileRepository;

    @Autowired
    public AileServiceImpl(AileRepository aileRepository) {
        this.aileRepository = aileRepository;
    }

    @Override
    public AileDto save(AileDto dto) {
        List<String> errors = AileValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Aile is not valid {}", dto);
            throw new InvalidEntityException("L'aile n'est pas valide", ErrorCodes.AILE_NOT_VALID, errors);
        }

        return AileDto.fromEntity(
                aileRepository.save(
                        AileDto.toEntity(dto)
                )
        );
    }

    @Override
    public AileDto findById(Integer id) {
        Aile aile = aileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucune aile avec l'ID = " + id + " n'a été trouvée dans la base de données",
                        ErrorCodes.AILE_NOT_FOUND));
        return AileDto.fromEntity(aile);
    }

    @Override
    public List<AileDto> findAll() {
        return aileRepository.findAll()
                .stream()
                .map(AileDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<String> findLigneNomByAileId(Integer id) {
        Optional<Aile> stadeOptional = aileRepository.findById(id);

        if(stadeOptional.isPresent()){
            Aile aile = stadeOptional.get();
            List<Ligne> lignes = aile.getLignes();
            if (lignes != null && !lignes.isEmpty()) {
                return lignes.stream()
                        .map(Ligne::getNom)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        aileRepository.deleteById(id);
    }


    @Override
    public AileDto findByNom(String nom) {
        Aile aile = aileRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException( "Aucune aile avec le Nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.AILE_NOT_FOUND));
        return AileDto.fromEntity(aile);
    }

}
