package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.enums.MealType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "MEAL_TIME")
public class MealTime {

    private @Id long mealId;
    private Integer hour;
    private String description;
    private long proteins;
    private long carbs;
    private long fats;
    private long calories;
    private long nutritionalPlanId;
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    public void update(MealTime meal) {
        this.hour = meal.hour;
        this.description = meal.description;
        this.proteins = meal.proteins;
        this.carbs = meal.carbs;
        this.fats = meal.fats;
        this.calories = meal.calories;
        this.nutritionalPlanId = meal.nutritionalPlanId;
    }
}
