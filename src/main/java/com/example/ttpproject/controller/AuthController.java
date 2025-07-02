package com.example.ttpproject.controller;

import com.example.ttpproject.dto.AuthDTO;
import com.example.ttpproject.model.LoginResponse;
import com.example.ttpproject.model.User;
import com.example.ttpproject.repository.UserRepository;
import com.example.ttpproject.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO loginData) {
        return authService.login(loginData.getEmail(), loginData.getPassword())
                .map(token -> ResponseEntity.ok(token))
                .orElse(ResponseEntity.status(401).body(new LoginResponse("Invalid email or password")));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDTO user) {
        return authService.register(user)
                .map(saved -> ResponseEntity.ok("User registered successfully"))
                .orElse(ResponseEntity.badRequest().body("Email already registered"));
    }

    @GetMapping("/user")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("In /user");
        String email = userDetails.getUsername();
        System.out.println(email);
        User user = userRepository.findByEmail(email).orElse(null);
        System.out.println("User from DB: " + user);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok(user);
    }
}

