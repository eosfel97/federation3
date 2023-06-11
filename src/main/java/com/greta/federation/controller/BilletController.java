package com.greta.federation.controller;

import com.greta.federation.controller.api.BilletApi;
import com.greta.federation.dto.UserDto;
import com.greta.federation.services.BilletService;
import com.greta.federation.dto.BilletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BilletController implements BilletApi {

    private final BilletService billetService;

    @Autowired
    public BilletController(BilletService billetService) {
        this.billetService = billetService;
    }


    @Override
    public BilletDto save(BilletDto dto, UserDto userDto) {
        return billetService.save(dto, userDto);
    }

    @Override
    public BilletDto findById(Integer id) {
        return billetService.findById(id);
    }

    @Override
    public List<BilletDto> findAll() {
        return billetService.findAll();
    }

    @Override
    public void delete(Integer id) {
        billetService.delete(id);
    }
}
