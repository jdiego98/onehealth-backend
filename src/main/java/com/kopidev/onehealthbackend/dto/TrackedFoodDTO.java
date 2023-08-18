package com.kopidev.onehealthbackend.dto;

import com.kopidev.onehealthbackend.entity.Food;
import com.kopidev.onehealthbackend.entity.TrackedMealFood;
import com.kopidev.onehealthbackend.enums.Measurements;
import com.kopidev.onehealthbackend.enums.Nutrients;
import com.kopidev.onehealthbackend.enums.PrivacyOptions;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TrackedFoodDTO {

    public Long mealTimeHistoryFoodId;
    public Long foodId;
    public float servings;
    public String name;
    public String measure;
    public float serving;
    public float carbs;
    public float protein;
    public float fat;
    public Integer calories;
    public String clasification;

    public TrackedFoodDTO(TrackedMealFood tracked) {
        this.mealTimeHistoryFoodId = tracked.getTrackedMealId();
        this.foodId = tracked.getFoodId();
        this.servings = tracked.getServings();
    }

    public void updateFood(Food food) {
        this.name = food.getName();
        this.measure = food.getMeasure().name();
        this.serving = food.getServing();
        this.carbs = food.getCarbs();
        this.protein = food.getProtein();
        this.fat = food.getFat();
        this.calories = food.getCalories();
        this.clasification = food.getClasification().name();
    }
}
