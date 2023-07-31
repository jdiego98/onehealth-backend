package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.config.security.JwtService;
import com.kopidev.onehealthbackend.dto.AuthRequestDTO;
import com.kopidev.onehealthbackend.dto.AuthResponseDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AuthenticationService {

    final UserRepository repo;
    final PasswordEncoder passwordEncoder;
    final JwtService jwtService;
    final AuthenticationManager authManager;

    public Object register(UserDTO dto) {
        User user = new User(dto);
        user.setPassword(passwordEncoder.encode(dto.password));
        repo.save(user);
        return new AuthResponseDTO(jwtService.generateToken(user));
    }

    public AuthResponseDTO authenticate(AuthRequestDTO dto) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email, dto.password));
        User user = repo.findByEmail(dto.email).orElseThrow();
        return new AuthResponseDTO(jwtService.generateToken(user));
    }
}
