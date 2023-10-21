package com.sunbase.demo.controller;

import com.sunbase.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate() {
        return authService.authenticate();
    }
}
