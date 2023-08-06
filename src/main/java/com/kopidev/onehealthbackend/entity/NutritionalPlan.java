package com.kopidev.onehealthbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "NUTRITIONAL_PLANS")
public class NutritionalPlan {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long nutritionalPlanId;
    private long userId;
    private long nutritionistId;
    private long startDate;
    private long endDate;
    private String goal;
    private long dailyProteinIntake;
    private long dailyCarbsIntake;
    private long dailyFatIntake;
    private long dailyCaloricIntake;

    public void update(NutritionalPlan plan) {
        this.startDate = plan.startDate;
        this.endDate = plan.endDate;
        this.goal = plan.goal;
        this.dailyProteinIntake = plan.dailyProteinIntake;
        this.dailyCarbsIntake = plan.dailyCarbsIntake;
        this.dailyFatIntake = plan.dailyFatIntake;
        this.dailyCaloricIntake = plan.dailyCaloricIntake;
    }
}
