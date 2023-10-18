package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Role;
import com.turkcell.spring.starter.entities.dtos.auth.AuthenticationResponse;
import com.turkcell.spring.starter.entities.dtos.auth.LoginRequest;
import com.turkcell.spring.starter.entities.dtos.auth.RegisterRequest;

import java.util.Set;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request, Set<Role> roles);
    AuthenticationResponse login(LoginRequest request);
}