package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.enums.Genders;

public class UserDTO {
    public Long id = (long) -1;

    public String name;
    public String lastName;
    public Long birthDay;
    public Genders gender;
    public String email;
    public CharSequence password;
    public String license;
}
