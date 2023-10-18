package com.turkcell.spring.starter.entities.dtos.auth;

import com.turkcell.spring.starter.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;


}