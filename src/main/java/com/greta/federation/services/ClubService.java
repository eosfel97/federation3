package com.greta.federation.services;


import com.greta.federation.dto.ClubDto;


import java.util.List;

public interface ClubService {
    ClubDto save(ClubDto dto);
    ClubDto update(Integer id, ClubDto updatedClub);

    ClubDto findByNom(String nom);

    List<ClubDto> findAll();
    ClubDto findById(Integer id);

    void delete(Integer id);
}
