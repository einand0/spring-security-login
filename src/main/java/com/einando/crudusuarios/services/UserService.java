package com.einando.crudusuarios.services;

import com.einando.crudusuarios.dtos.RegisterRequestDTO;
import com.einando.crudusuarios.entities.User;
import com.einando.crudusuarios.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(RegisterRequestDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
}
