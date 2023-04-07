package greta.federation.controller.api;

import greta.federation.dto.ChangerMotDePasseUserDto;
import greta.federation.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static greta.federation.utils.Constants.USER_ENDPOINT;

@Api("users")
public interface UserApi {

    @PostMapping(USER_ENDPOINT + "/create")
    UserDto save(@RequestBody UserDto dto);

    @PostMapping(USER_ENDPOINT + "/update/password")
    UserDto changerMotDePasse(@RequestBody ChangerMotDePasseUserDto dto);

    @GetMapping(USER_ENDPOINT + "/{id_user}")
    UserDto findById(@PathVariable("id_user") Integer id);

    @GetMapping(USER_ENDPOINT + "/find/{email}")
    UserDto findByEmail(@PathVariable("email") String email);

    @GetMapping(USER_ENDPOINT + "/all")
    List<UserDto> findAll();

    @DeleteMapping(USER_ENDPOINT + "/delete/{id_user}")
    void delete(@PathVariable("id_user") Integer id);
}
