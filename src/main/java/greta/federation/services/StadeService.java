package greta.federation.services;

import greta.federation.dto.StadeDto;

import java.util.List;

public interface StadeService {
    StadeDto save(StadeDto dto);
    StadeDto findById(Integer id);
    List<StadeDto> findAll();

    StadeDto findByNom(String nom);

    StadeDto update(Integer id, StadeDto updatedStade);
    void delete(Integer id);
}
