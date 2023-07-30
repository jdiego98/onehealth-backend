package com.kopidev.onehealthbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String lastName;
    private long birthDay;
    private boolean gender;
    private String email;
    private String password;

}
