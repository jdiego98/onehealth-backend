package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.User;

public class AuthResponseDTO {
    public String token;
    public long id;
    public String name;
    public String lastName;
    public final String email;
    public Long birthday;
    public String gender;
    public String password;
    public String type;
    public String license;

    public AuthResponseDTO(User user, String token) {
        this.token = token;
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthday = user.getBirthDay();
        this.gender = user.getGender().name();
        this.password = user.getPassword();
        this.type = user.getRole().name();
        this.license = user.getLicense();
    }
}
