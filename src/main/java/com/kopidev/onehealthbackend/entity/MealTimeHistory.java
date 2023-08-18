package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.dto.MealTimeHistoryDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Entity @Table(name = "MEAL_TIME_HISTORY") @Getter @Setter
public class MealTimeHistory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long id;
    private long date;
    private long totalCalories;
    private long mealTimeId;
    private long nutritionalPlanId;

    public void update(MealTimeHistoryDTO dto, NutritionalPlan plan) {
        this.date = dto.date;
        this.totalCalories = dto.totalCalories;
        this.mealTimeId = dto.mealTimeId;
        this.nutritionalPlanId = plan.getNutritionalPlanId();
    }
}
