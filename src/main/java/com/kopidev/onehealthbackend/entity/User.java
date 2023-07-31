package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.enums.Genders;
import com.kopidev.onehealthbackend.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long id;
    private String name;
    private String lastName;
    private Long birthDay;
    @Enumerated(EnumType.STRING)
    private Genders gender;
    @NotBlank
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public User(UserDTO dto) {
        this.name = dto.name;
        this.lastName = dto.lastName;
        this.birthDay = dto.birthDay;
        this.gender = Genders.valueOf(dto.gender);
        this.email = dto.email;
        this.role = Roles.CLIENT;
    }

    public void update(UserDTO dto) {
        this.name = dto.name;
        this.lastName = dto.lastName;
        this.birthDay = dto.birthDay;
        this.gender = Genders.valueOf(dto.gender);
        this.email = dto.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
