package com.example.TalentUp.service.auth;

import com.example.TalentUp.dto.LoginRequest;
import com.example.TalentUp.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
