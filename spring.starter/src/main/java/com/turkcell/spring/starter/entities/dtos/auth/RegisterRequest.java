package com.turkcell.spring.starter.entities.dtos.auth;

import com.turkcell.spring.starter.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String name;
    private String lastName;


}