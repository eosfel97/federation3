package greta.federation.services;

import greta.federation.dto.EquipeDto;

import java.util.List;

public interface EquipeService {
    EquipeDto save(EquipeDto dto);
    EquipeDto findById(Integer id);
    EquipeDto findByNom(String nom);
    List<EquipeDto> findAll();
    void delete(Integer id);
}
