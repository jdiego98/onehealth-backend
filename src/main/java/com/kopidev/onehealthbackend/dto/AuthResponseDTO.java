package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.enums.Roles;
import lombok.AllArgsConstructor;

public class AuthResponseDTO {
    public String token;
    private final long userId;
    private final String email;
    public String name;
    public Roles userRole;

    public AuthResponseDTO(User user, String token) {
        this.token = token;
        this.userId = user.getId();
        this.name = user.getFullName();
        this.email = user.getEmail();
        this.userRole = user.getRole();
    }
}
