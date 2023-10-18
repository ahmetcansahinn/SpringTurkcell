package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Role;
import com.turkcell.spring.starter.entities.dtos.auth.AuthenticationResponse;
import com.turkcell.spring.starter.entities.dtos.auth.LoginRequest;
import com.turkcell.spring.starter.entities.dtos.auth.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request, Role role);
    AuthenticationResponse login(LoginRequest request);
}