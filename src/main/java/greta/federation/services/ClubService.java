package greta.federation.services;


import greta.federation.dto.ArticleDto;
import greta.federation.dto.ClubDto;


import java.util.List;

public interface ClubService {
    ClubDto save(ClubDto dto);
    ClubDto update(Integer id, ClubDto updatedClub);

    ClubDto findByNom(String nom);

    List<ClubDto> findAll();
    ClubDto findById(Integer id);

    void delete(Integer id);
}
