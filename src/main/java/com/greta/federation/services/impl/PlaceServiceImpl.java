package com.greta.federation.services.impl;

import com.greta.federation.entity.Place;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.PlaceService;
import com.greta.federation.dto.PlaceDto;
import com.greta.federation.repository.PlaceRepository;
import com.greta.federation.validator.PlaceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceDto save(PlaceDto dto) {
        List<String> errors = PlaceValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La place n'est pas valide {}", dto);
            throw new InvalidEntityException("La place n'est pas valide", ErrorCodes.PLACE_NOT_VALID, errors);
        }

        return PlaceDto.fromEntity(
                placeRepository.save(
                        PlaceDto.toEntity(dto)
                )
        );
    }

    @Override
    public PlaceDto findById(Integer id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucune place avec l'ID = " + id + " n'a été trouvée dans la base de données",
                        ErrorCodes.PLACE_NOT_FOUND));
        return PlaceDto.fromEntity(place);
    }

    @Override
    public List<PlaceDto> findAll() {
        return placeRepository.findAll()
                .stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> findByAile(String aile) {
        if (!StringUtils.hasLength(aile)) {
            log.error("Le nom de l'aile est null");
            return null;
        }

        return placeRepository.findByAile(aile)
                .stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> findByLigne(String ligne) {
        if (!StringUtils.hasLength(ligne)) {
            log.error("Le nom de la ligne est null");
            return null;
        }

        return placeRepository.findByLigne(ligne)
                .stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> findByNumLigne(String numLigne) {
        if (!StringUtils.hasLength(numLigne)) {
            log.error("Le numéro de ligne est null");
            return null;
        }

        return placeRepository.findByNumLigne(numLigne)
                .stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> findByStadeId(Integer idStade) {
        return placeRepository.findByStadeId(idStade)
                .stream()
                .map(PlaceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        placeRepository.deleteById(id);
    }
}
