package com.kopidev.onehealthbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kopidev.onehealthbackend.dto.RegistrationDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.enums.Genders;
import com.kopidev.onehealthbackend.enums.PasswordStatus;
import com.kopidev.onehealthbackend.enums.Roles;
import com.kopidev.onehealthbackend.enums.UserStatus;
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
    private String license;
    @Enumerated(EnumType.STRING)
    private Roles role;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Enumerated(EnumType.STRING)
    private PasswordStatus passwordStatus;

    private Long nutritionistId;

    public User(RegistrationDTO dto) {
        this.name = dto.name;
        this.lastName = dto.lastName;
        this.birthDay = dto.birthDay;
        this.gender = Genders.valueOf(dto.gender);
        this.email = dto.email;
    }

    public void updateClient(Long nutritionistId) {
        this.role = Roles.CLIENT;
        this.userStatus = UserStatus.ACTIVE;
        this.passwordStatus = PasswordStatus.EXPIRED;
        this.nutritionistId = nutritionistId;
    }

    public void updateNutritionist(RegistrationDTO dto) {
        this.license = dto.license;
        this.role = Roles.NUTRITIONIST;
        this.userStatus = UserStatus.PENDING;
        this.passwordStatus = PasswordStatus.ACTIVE;
    }

    public void update(UserDTO dto) {
        this.name = dto.name;
        this.lastName = dto.lastName;
        this.birthDay = dto.birthDay;
        this.gender = dto.gender;
        this.email = dto.email;
        this.license = dto.license;
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
        return this.userStatus.equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.userStatus.equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.passwordStatus.equals(PasswordStatus.ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return this.userStatus.equals(UserStatus.ACTIVE);
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }



}
