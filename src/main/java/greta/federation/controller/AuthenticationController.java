package greta.federation.controller;

import greta.federation.controller.api.AuthenticationApi;
import greta.federation.dto.auth.AuthenticationRequest;
import greta.federation.dto.auth.AuthenticationResponse;
import greta.federation.entity.auth.ExtendedUser;
import greta.federation.services.auth.ApplicationUserDetailsService;
import greta.federation.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

@RestController
public class AuthenticationController implements AuthenticationApi {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final ExtendedUser extendedUser = (ExtendedUser) userDetails;

        final String jwt = jwtUtil.generateToken(extendedUser);
        // Récupérer le rôle de l'utilisateur
        String userRole = extendedUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse(null);


        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).userRole(userRole).build());

    }
}
