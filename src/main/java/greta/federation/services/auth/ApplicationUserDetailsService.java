package greta.federation.services.auth;

import greta.federation.dto.UserDto;
import greta.federation.entity.auth.ExtendedUser;
import greta.federation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = service.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getNom())));

        return new ExtendedUser(user.getEmail(), user.getPassword(), authorities);
    }
}