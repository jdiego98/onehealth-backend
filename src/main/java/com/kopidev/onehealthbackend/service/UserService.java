package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.Role;
import com.kopidev.onehealthbackend.repository.RoleRepository;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
@Transactional
public class UserService {

    UserRepository userRepo;
    RoleRepository roleRepo;
    PasswordEncoder passEncoder;

    public User saveUser(UserDTO dto){
        User user = this.userRepo.findById(dto.id).orElseGet(User::new);
        user.update(dto);
        user.setPassword(passEncoder.encode(dto.password));
        Role role = roleRepo.findByName(dto.type.name()).orElseGet(() -> new Role(dto.type.name()));
        user.setRoles(Arrays.asList(role));
        return userRepo.save(user);
    }
    
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(long id){
        return userRepo.findById(id).orElseThrow();
    }

    public  String deleteUser(long id){
        userRepo.deleteById(id);
        return "user removed";
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
