package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.NutritionalPlan;
import com.kopidev.onehealthbackend.entity.User;

public class ClientDTO {

    public long id;
    public String name;
    public String lastName;
    public String email;
    public String gender;
    public String password = "";
    public String role = "CLIENTE";
    public String license = "";
    public long nutritionistId;

    public ClientDTO(User client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.gender = client.getGender().name();
        this.nutritionistId = client.getNutritionistId();
    }
}
