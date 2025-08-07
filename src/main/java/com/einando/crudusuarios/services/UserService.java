package com.einando.crudusuarios.services;

import com.einando.crudusuarios.dtos.LoginRequestDTO;
import com.einando.crudusuarios.dtos.LoginResponseDTO;
import com.einando.crudusuarios.dtos.RegisterRequestDTO;
import com.einando.crudusuarios.entities.User;
import com.einando.crudusuarios.repositories.UserRepository;
import com.einando.crudusuarios.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(RegisterRequestDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        return userRepository.save(user);
    }

    public LoginResponseDTO loginUser(LoginRequestDTO dto){
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        if(!passwordEncoder.matches(dto.password(),user.getPassword())){


            throw new RuntimeException("Usuário ou senha inválidos.");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponseDTO(token);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
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
