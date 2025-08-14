package com.modstack.backend.service;

import com.modstack.backend.dto.RegisterRequest;
import com.modstack.backend.model.User;
import com.modstack.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.email())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User u = new User();
        u.setFirstName(req.firstName());
        u.setLastName(req.lastName());
        u.setEmail(req.email().toLowerCase());
        u.setPasswordHash(passwordEncoder.encode(req.password()));
        u.setRole("USER");                 // default role
        u.setAuthProvider("local");
        u.setCreatedAt(Instant.now());

        return userRepository.save(u);
    }
}