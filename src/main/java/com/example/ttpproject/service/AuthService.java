package com.example.ttpproject.service;

import com.example.ttpproject.model.User;
import com.example.ttpproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String email, String rawPassword) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && BCrypt.checkpw(rawPassword, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return Optional.empty();
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return Optional.of(userRepository.save(user));
    }
}