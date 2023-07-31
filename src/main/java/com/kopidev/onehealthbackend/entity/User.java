package com.kopidev.onehealthbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    private String email;
    private long birthDay;
    private Boolean gender;
    private String type;
    private String password;

    @OneToMany(mappedBy="user")
    private Set<BodyMeasurement> bodyMeasurements;
}
