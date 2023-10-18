package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.AuthService;
import com.turkcell.spring.starter.entities.Role;
import com.turkcell.spring.starter.entities.dtos.auth.AuthenticationResponse;
import com.turkcell.spring.starter.entities.dtos.auth.LoginRequest;
import com.turkcell.spring.starter.entities.dtos.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("login")
    public AuthenticationResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @PostMapping("register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request, @RequestParam Set<Role> roles){
        return  authService.register(request,roles);
    }
}

