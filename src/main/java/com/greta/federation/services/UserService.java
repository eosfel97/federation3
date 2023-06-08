package com.greta.federation.services;

import com.greta.federation.dto.ChangerMotDePasseUserDto;
import com.greta.federation.dto.UserDto;

import java.util.List;

public interface UserService {


    UserDto save(UserDto dto);

    UserDto findById(Integer id);

    List<UserDto> findAll();

    void delete(Integer id);

    UserDto findByEmail(String email);

    UserDto changerMotDePasse(ChangerMotDePasseUserDto dto);
}
