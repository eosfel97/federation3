package greta.federation.controller.api;

import greta.federation.dto.auth.AuthenticationRequest;
import greta.federation.dto.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static greta.federation.utils.Constants.AUTHENTICATION_ENDPOINT;

public interface AuthenticationApi {
    @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
