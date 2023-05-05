package com.greta.federation.services;

import com.greta.federation.dto.RencontreDto;

import java.util.List;

public interface RencontreService {
    RencontreDto create(RencontreDto rencontreDto);

    RencontreDto findById(Integer id);

    List<RencontreDto> findAll();

    RencontreDto update(Integer id, RencontreDto rencontreDto);

    void delete(Integer id);
}
