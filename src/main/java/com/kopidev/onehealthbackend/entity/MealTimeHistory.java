package com.kopidev.onehealthbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kopidev.onehealthbackend.dto.FoodDTO;
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

    @ManyToOne
    @JoinColumn(name = "mealTime_id")
    @JsonBackReference
    private MealTime mealTime;

    @ManyToOne
    @JoinColumn(name = "nutritionalPlan_id")
    @JsonBackReference
    private NutritionalPlan nutritionalPlan;

    @ManyToMany
    @JoinTable(
            name = "MEAL_TIME_HISTORY_FOODS",
            joinColumns = @JoinColumn(name = "mealTimeHistory_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> foods;


}
