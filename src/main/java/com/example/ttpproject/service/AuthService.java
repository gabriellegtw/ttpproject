package com.example.ttpproject.service;

import com.example.ttpproject.dto.AuthDTO;
import com.example.ttpproject.model.User;
import com.example.ttpproject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String email, String rawPassword) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && BCrypt.checkpw(rawPassword, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> register(AuthDTO authDto) {
        if (userRepository.findByEmail(authDto.getEmail()).isPresent()) {
            return Optional.empty();
        }
        String hashedPassword = BCrypt.hashpw(authDto.getPassword(), BCrypt.gensalt());
        User user = new User();
        user.setEmail(authDto.getEmail());
        user.setPassword(hashedPassword);

        User savedUser = userRepository.save(user);
        return Optional.of(savedUser);
    }
}