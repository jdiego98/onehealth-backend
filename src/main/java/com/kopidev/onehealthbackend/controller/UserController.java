package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllProducts(){
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findProductById(@PathVariable long id){
        return service.getUsersById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }


}
