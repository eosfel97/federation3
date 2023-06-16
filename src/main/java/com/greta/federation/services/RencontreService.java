package com.greta.federation.services;

import com.greta.federation.dto.RencontreDto;

import java.util.List;
import java.util.Map;

public interface RencontreService {
    RencontreDto create(RencontreDto rencontreDto);

    RencontreDto findById(Integer id);

    List<RencontreDto> findAll();

    RencontreDto update(Integer id, RencontreDto rencontreDto);
    List<Map<String, Object>> findAllSummaries();


    void delete(Integer id);
}
