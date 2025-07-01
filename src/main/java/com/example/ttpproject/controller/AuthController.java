package com.example.ttpproject.controller;

import com.example.ttpproject.model.User;
import com.example.ttpproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) {
        return authService.login(loginData.getEmail(), loginData.getPassword())
                .map(user -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return authService.register(user)
                .map(saved -> ResponseEntity.ok("User registered successfully"))
                .orElse(ResponseEntity.badRequest().body("Email already registered"));
    }
}

