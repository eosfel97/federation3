package com.greta.federation.services;
import com.greta.federation.dto.CommandeDto;
import java.util.List;


public interface CommandeService {

    CommandeDto save(CommandeDto dto);


    CommandeDto findById(Integer id);


    List<CommandeDto> findAll();



    void delete(Integer id);
}