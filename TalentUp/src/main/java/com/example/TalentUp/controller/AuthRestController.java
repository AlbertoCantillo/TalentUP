
package com.example.TalentUp.controller;

import com.example.TalentUp.dto.LoginRequest;
import com.example.TalentUp.dto.LoginResponse;
import com.example.TalentUp.service.auth.AuthService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final AuthService authService;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}
