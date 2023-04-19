package greta.federation.services;

import greta.federation.dto.EvenementRencontreDto;

import java.util.List;

public interface EvenementRencontreService {
    EvenementRencontreDto save(EvenementRencontreDto dto);
    EvenementRencontreDto findById(Integer id);
    List<EvenementRencontreDto> findAll();
    void delete(Integer id);
    EvenementRencontreDto update(Integer id, EvenementRencontreDto updatedEvenementRencontre);
}