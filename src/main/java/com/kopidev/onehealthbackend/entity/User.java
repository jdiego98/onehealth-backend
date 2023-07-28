package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long id;
    private String name;
    private String lastName;
    private Long birthDay;
    private boolean gender;
    private String email;
    private String password;
    private String type;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles = new ArrayList<>();

    public void update(UserDTO dto) {
        this.name = dto.name;
        this.lastName = dto.lastName;
        this.birthDay = dto.birthDay;
        this.gender = dto.gender;
        this.email = dto.email;
        this.type = dto.type.name();
    }
}
