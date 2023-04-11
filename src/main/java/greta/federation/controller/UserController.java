package greta.federation.controller;

import greta.federation.controller.api.UserApi;
import greta.federation.dto.ChangerMotDePasseUserDto;
import greta.federation.dto.UserDto;
import greta.federation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController implements UserApi {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDto save(UserDto dto){return userService.save(dto);}
    @Override
    public UserDto changerMotDePasse(ChangerMotDePasseUserDto dto) {
        return userService.changerMotDePasse(dto);
    }
    @Override
    public UserDto findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userService.findByEmail(email);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }

}
