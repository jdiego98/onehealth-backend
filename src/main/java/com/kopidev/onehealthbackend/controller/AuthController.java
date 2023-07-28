package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController @CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth") @AllArgsConstructor
public class AuthController {

    UserService service;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registration(@RequestBody UserDTO dto) {
        Optional<User> existing = service.findByEmail(dto.email);
        if (existing.isPresent())
            throw new IllegalStateException();
        return new ResponseEntity<>(service.saveUser(dto), HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }


}
