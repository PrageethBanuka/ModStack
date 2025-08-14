package com.modstack.backend.controller;

import com.modstack.backend.dto.RegisterRequest;
import com.modstack.backend.model.User;
import com.modstack.backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        try {
            User saved = authService.register(req);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RegistrationResponse(saved.getId(), saved.getEmail()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    record RegistrationResponse(String id, String email) {}
}
