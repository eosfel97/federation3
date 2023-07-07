package com.greta.federation.controller.api;

import com.greta.federation.dto.auth.AuthenticationRequest;
import com.greta.federation.dto.auth.AuthenticationResponse;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("authentication")
@CrossOrigin(origins = "http://localhost:3000")
public interface AuthenticationApi {
    @PostMapping(Constants.AUTHENTICATION_ENDPOINT + "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
