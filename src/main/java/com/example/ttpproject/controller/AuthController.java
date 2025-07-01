package com.example.ttpproject.controller;

import com.example.ttpproject.dto.AuthDTO;
import com.example.ttpproject.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO loginData) {
        return authService.login(loginData.getEmail(), loginData.getPassword())
                .map(user -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDTO user) {
        return authService.register(user)
                .map(saved -> ResponseEntity.ok("User registered successfully"))
                .orElse(ResponseEntity.badRequest().body("Email already registered"));
    }
}

