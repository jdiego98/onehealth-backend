package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.Food;
import com.kopidev.onehealthbackend.enums.MealType;

import java.util.Date;
import java.util.List;

public class MealTimeHistoryDTO {
    public Long mealTimeHistoryId;
    public Long mealTimeId;
    public Long nutritionalPlanId;
    public MealType mealType;
    public Integer hour;
    public long idealcalories;
    public long totalCalories;
    public long date;
    public List<TrackedFoodDTO> foods;
}
