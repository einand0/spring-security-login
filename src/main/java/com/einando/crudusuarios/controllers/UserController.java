package com.einando.crudusuarios.controllers;

import com.einando.crudusuarios.dtos.RegisterRequestDTO;
import com.einando.crudusuarios.dtos.RegisterResponseDTO;
import com.einando.crudusuarios.entities.User;
import com.einando.crudusuarios.services.UserService;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public RegisterResponseDTO createUser(@RequestBody RegisterRequestDTO dto){
        User user = userService.saveUser(dto);
        return new RegisterResponseDTO(user.getId(), user.getName());
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "Usuário deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        Optional<User> user = userService.findUserById(id);

        if(user.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }

        user.get().setName(updatedUser.getName());
        user.get().setEmail(updatedUser.getEmail());
        user.get().setPassword(updatedUser.getPassword());

        return userService.updateUser(user.get());
    }
}
