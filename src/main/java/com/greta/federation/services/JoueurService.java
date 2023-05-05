package com.greta.federation.services;

import com.greta.federation.dto.JoueurDto;

import java.util.List;

public interface JoueurService {
    JoueurDto save(JoueurDto dto);
    JoueurDto update(Integer id, JoueurDto updatedJoueur);
    JoueurDto findById(Integer id);
    JoueurDto findByNom(String nom);
    List<JoueurDto> findAll();
    void delete(Integer id);
}
