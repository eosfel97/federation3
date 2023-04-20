package com.greta.federation.services;

import com.greta.federation.dto.ArbitreDto;
import java.util.List;

public interface ArbitreService {

    ArbitreDto save(ArbitreDto dto);

    ArbitreDto findById(Integer id);

    List<ArbitreDto> findAll();

    void delete(Integer id);
}
