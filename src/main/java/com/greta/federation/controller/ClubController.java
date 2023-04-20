package com.greta.federation.controller;

import com.greta.federation.services.ClubService;
import com.greta.federation.controller.api.ClubApi;
import com.greta.federation.dto.ClubDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClubController implements ClubApi {
    private final ClubService clubService;
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @Override
    public ClubDto save(ClubDto dto) {
        return clubService.save(dto);
    }
    @Override
    public ClubDto update(Integer id, ClubDto updatedClub) {
        return clubService.update(id, updatedClub);
    }
    @Override
    public ClubDto findById(Integer id) {
        return clubService.findById(id);
    }

    @Override
    public ClubDto findByNom(String nom) {
        return clubService.findByNom(nom);
    }

    @Override
    public List<ClubDto> findAll() {
        return clubService.findAll();
    }


    @Override
    public void delete(Integer id) {
        clubService.delete(id);
    }

}
