package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.enums.UserType;

public class UserDTO {
    public Long id;
    public String name;
    public String lastName;
    public Long birthDay;
    public boolean gender;
    public String email;
    public UserType type;
    public CharSequence password;
}
