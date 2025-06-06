package com.greta.federation.services.impl;

import com.greta.federation.dto.ArbitreDto;
import com.greta.federation.entity.Arbitre;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.services.ArbitreService;
import com.greta.federation.repository.ArbitreRepository;
import com.greta.federation.validator.ArbitreValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArbitreServiceImpl implements ArbitreService {

    private final ArbitreRepository arbitreRepository;

    @Autowired
    public ArbitreServiceImpl(ArbitreRepository arbitreRepository) {
        this.arbitreRepository = arbitreRepository;
    }

    @Override
    public ArbitreDto save(ArbitreDto dto) {
        List<String> errors = ArbitreValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Arbitre is not valid {}", dto);
            throw new InvalidEntityException("l'Arbitre n'est pas valide", ErrorCodes.ARBITRE_NOT_VALID, errors);
        }

        return ArbitreDto.fromEntity(
                arbitreRepository.save(
                        ArbitreDto.toEntity(dto)
                )
        );
    }

    @Override
    public ArbitreDto findById(Integer id) {
        if (id == null) {
            log.error("Club ID is null");
            return null;
        }
        return arbitreRepository.findById(id).map(ArbitreDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Arbitre avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARBITRE_NOT_FOUND)
        );
    }
    @Override
    public List<ArbitreDto> findAll() {
        return arbitreRepository.findAll()
                .stream()
                .map(ArbitreDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Arbitre arbitre = arbitreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Arbitre not found with id: " + id));
        arbitreRepository.delete(arbitre);
    }
}
