package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.dto.AuthRequestDTO;
import com.kopidev.onehealthbackend.dto.AuthResponseDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.AuthenticationService;
import com.kopidev.onehealthbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController {

    final AuthenticationService service;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value ="/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok(service.authenticate(dto));
    }

}
