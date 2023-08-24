package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.ClientDTO;
import com.kopidev.onehealthbackend.dto.UserDTO;
import com.kopidev.onehealthbackend.entity.NutritionalPlan;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.enums.UserStatus;
import com.kopidev.onehealthbackend.repository.NutritionalPlanRepository;
import com.kopidev.onehealthbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @AllArgsConstructor
@Transactional
public class UserService {

    UserRepository userRepo;
    PasswordEncoder passEncoder;
    NutritionalPlanRepository planRepo;

    public User saveUser(UserDTO dto){
        User user = this.userRepo.findById(dto.id).orElseThrow();
        user.update(dto);
        if (dto.password != null)
            user.setPassword(passEncoder.encode(dto.password));
        return userRepo.save(user);
    }
    
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public  String deleteUser(long id){
        userRepo.deleteById(id);
        return "user removed";
    }

    public List<ClientDTO> findAllClients(long id) {
        List<ClientDTO> dtoList = new ArrayList<>();
        List<User> clients = this.userRepo.findAllByNutritionistId(id);
        for (User client: clients) {
            dtoList.add(new ClientDTO(client));
        }
        return dtoList;
    }

    public Object activateNutritionist(long id) {
        User nutritionist = this.userRepo.findById(id).orElseThrow();
        nutritionist.setUserStatus(UserStatus.ACTIVE);
        return this.userRepo.save(nutritionist);
    }
}
