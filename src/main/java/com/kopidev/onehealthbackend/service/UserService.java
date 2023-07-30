package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
       return repository.save(user);
    }

    
    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUsersById(long id){
        return repository.findById(id).orElse(null);
    }

    public  String deleteUser(long id){
        repository.deleteById(id);
        return "user removed";
    }

    public User updateUser(User user){
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBirthDay(user.getBirthDay());
        existingUser.setGender(user.isGender());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPassword(user.getType());

        return  repository.save(existingUser);
    }
}
