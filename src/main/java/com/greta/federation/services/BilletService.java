package com.greta.federation.services;
import com.greta.federation.dto.BilletDto;
import com.greta.federation.dto.UserDto;

import java.util.List;



public interface   BilletService {


    BilletDto save(BilletDto dto, UserDto userDto);

    BilletDto findById(Integer id);

    List<BilletDto> findAll();

    void delete(Integer id);
}

