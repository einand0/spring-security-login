package com.einando.crudusuarios.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public ResponseEntity<String> getProfile(Principal principal){
        String email = principal.getName();
        return ResponseEntity.ok("Usuário autenticado: " + email);
    }
}
