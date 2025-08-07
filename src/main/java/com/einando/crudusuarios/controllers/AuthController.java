package com.einando.crudusuarios.controllers;

import com.einando.crudusuarios.dtos.LoginRequestDTO;
import com.einando.crudusuarios.dtos.LoginResponseDTO;
import com.einando.crudusuarios.dtos.RegisterRequestDTO;
import com.einando.crudusuarios.dtos.RegisterResponseDTO;
import com.einando.crudusuarios.entities.User;
import com.einando.crudusuarios.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerUser(@RequestBody RegisterRequestDTO dto){
        User savedUser = userService.saveUser(dto);

        return ResponseEntity.ok(new RegisterResponseDTO(savedUser.getId(), savedUser.getName()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO dto) {
        LoginResponseDTO response = userService.loginUser(dto);
        return ResponseEntity.ok(response);
    }

}
