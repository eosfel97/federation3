package com.greta.federation.controller.api;

import com.greta.federation.utils.Constants;
import com.greta.federation.dto.ChangerMotDePasseUserDto;
import com.greta.federation.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("users")
public interface UserApi {

    @PostMapping(Constants.USER_ENDPOINT + "/create")
    UserDto save(@RequestBody UserDto dto);

    @PostMapping(Constants.USER_ENDPOINT + "/update/password")
    UserDto changerMotDePasse(@RequestBody ChangerMotDePasseUserDto dto);

    @GetMapping(Constants.ADMIN_ENDPOINT + "/{id_user}")
    UserDto findById(@PathVariable("id_user") Integer id);

    @GetMapping(Constants.ADMIN_ENDPOINT + "/find/{email}")
    UserDto findByEmail(@PathVariable("email") String email);

    @GetMapping(Constants.ADMIN_ENDPOINT + "/users/all")
    List<UserDto> findAll();

    @DeleteMapping(Constants.ADMIN_ENDPOINT + "/delete/{id_user}")
    void delete(@PathVariable("id_user") Integer id);
}
