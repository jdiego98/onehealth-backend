package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.MealTimeHistoryDTO;
import com.kopidev.onehealthbackend.entity.MealTime;
import com.kopidev.onehealthbackend.entity.NutritionalPlan;
import com.kopidev.onehealthbackend.repository.MealTimeRepository;
import com.kopidev.onehealthbackend.repository.NutritionalPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class NutritionalPlanService {

    NutritionalPlanRepository repo;
    MealTimeRepository mealRepo;

    public NutritionalPlan savePlan(NutritionalPlan plan) {
        NutritionalPlan persisted = this.repo.findById(plan.getNutritionalPlanId()).orElseGet(NutritionalPlan::new);
        persisted.update(plan);
        return this.repo.save(persisted);
    }

    public List<NutritionalPlan> getClientsPlans(long id) {
        return this.repo.findAllByUserId(id);
    }

    public MealTime saveMealTime(MealTime meal) {
        MealTime persisted = this.mealRepo.findById(meal.getMealId()).orElseGet(MealTime::new);
        persisted.update(meal);
        return this.mealRepo.save(persisted);
    }

}
