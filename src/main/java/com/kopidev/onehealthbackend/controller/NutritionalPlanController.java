package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.entity.MealTime;
import com.kopidev.onehealthbackend.entity.NutritionalPlan;
import com.kopidev.onehealthbackend.service.NutritionalPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans") @AllArgsConstructor
public class NutritionalPlanController {

    NutritionalPlanService service;

    @PostMapping
    public ResponseEntity<NutritionalPlan> saveNutritionalPlan(@RequestBody NutritionalPlan plan) {
        return ResponseEntity.ok(this.service.savePlan(plan));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<NutritionalPlan>> getAllUserPlans(@PathVariable long id) {
        return ResponseEntity.ok(this.service.getClientsPlans(id));
    }

    @PostMapping("/mealtime")
    public ResponseEntity<MealTime> saveMealTime(@RequestBody MealTime meal) {
        return ResponseEntity.ok(this.service.saveMealTime(meal));
    }

}
