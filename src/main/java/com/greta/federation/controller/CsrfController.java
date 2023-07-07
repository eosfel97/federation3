package com.greta.federation.controller;
import com.greta.federation.utils.Constants;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CsrfController {

    @GetMapping(value = "/" + Constants.APP_ROOT + "/csrf-token")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}