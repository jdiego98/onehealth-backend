package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.dto.ClientDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users") @AllArgsConstructor
public class UserController {
    UserService service;

    @GetMapping
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<List<ClientDTO>> findClientsByNutritionistId(@PathVariable long id) {
        return ResponseEntity.ok(this.service.findAllClients(id));
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<Object> activatePendingNutritionist(@PathVariable long id) {
        return ResponseEntity.ok(this.service.activateNutritionist(id));
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody UserDTO dto){
        return service.saveUser(dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }


}
