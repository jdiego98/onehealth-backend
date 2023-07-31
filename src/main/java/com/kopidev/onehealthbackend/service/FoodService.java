package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.FoodDTO;
import com.kopidev.onehealthbackend.entity.Food;
import com.kopidev.onehealthbackend.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class FoodService {

    FoodRepository repo;

    public Object save(FoodDTO dto) {
        Food food = this.repo.findById(dto.foodId).orElseGet(Food::new);
        food.update(dto);
        food = this.repo.save(food);
        dto.foodId = food.getFoodId();
        return dto;
    }

    public void saveAll(List<FoodDTO> dto) {
        dto.forEach(this::save);
    }
}
