package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.Food;
import com.kopidev.onehealthbackend.enums.MealType;

import java.util.Date;
import java.util.List;

public class MealTimeHistoryDTO {
    public Long mealTimeId;
    public Long mealTimeHistoryId;
    public MealType mealType;
    public Integer hour;
    public long idealcalories;
    public long totalCalories;
    public long date;
    public List<Food> foods;
}
