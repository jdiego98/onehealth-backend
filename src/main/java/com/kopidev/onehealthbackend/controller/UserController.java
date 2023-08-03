package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users") @AllArgsConstructor
public class UserController {
    UserService service;

    @PostMapping(value = "/add")
    public User addUser(@RequestBody UserDTO dto){

        return service.saveUser(dto);
    }

    @GetMapping("/get")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/get/{id}")
    public User findUserById(@PathVariable long id){
        return service.getUserById(id);
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
