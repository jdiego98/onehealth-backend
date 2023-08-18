package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.dto.TrackedFoodDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity @Getter @Setter @Table(name = "MEAL_TIME_HISTORY_FOODS")
public class TrackedMealFood {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long trackedMealId;
    private Long mealTimeHistoryId;
    private Long foodId;
    private float servings;
}
