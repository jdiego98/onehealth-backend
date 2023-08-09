package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.config.security.JwtService;
import com.kopidev.onehealthbackend.dto.AuthRequestDTO;
import com.kopidev.onehealthbackend.dto.AuthResponseDTO;
import com.kopidev.onehealthbackend.dto.RegistrationDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class AuthenticationService {

    final UserRepository repo;
    final PasswordEncoder passwordEncoder;
    final JwtService jwtService;
    final AuthenticationManager authManager;

    public Object register(RegistrationDTO dto) {
        Optional<User> optUser = this.repo.findByEmail(dto.email);
        if (optUser.isPresent())
            throw new IllegalStateException("El usuario ya se encuentra registrado");
        Optional<User> nutritionist = this.repo.findById(dto.nutritionistId);
        User user = new User(dto);
        if (nutritionist.isPresent())
            user.updateClient(nutritionist.get().getNutritionistId());
        else if (dto.license != null)
            user.updateNutritionist(dto);
        else
            throw new IllegalStateException("Información insuficiente para determinar el estado del usuario");
        user.setPassword(passwordEncoder.encode(dto.password));
        repo.save(user);
        return new AuthResponseDTO(user, jwtService.generateToken(user));
    }

    public AuthResponseDTO authenticate(AuthRequestDTO dto) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email, dto.password));
        User user = repo.findByEmail(dto.email).orElseThrow();
        return new AuthResponseDTO(user, jwtService.generateToken(user));
    }
}
