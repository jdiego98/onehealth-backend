package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.MealTimeHistoryDTO;
import com.kopidev.onehealthbackend.dto.TrackedFoodDTO;
import com.kopidev.onehealthbackend.entity.*;
import com.kopidev.onehealthbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class MealTimeHistoryService {

    MealTimeRepository mealTimeRepo;
    MealTimeHistoryRepository mealTimeHistoRepo;
    NutritionalPlanRepository planRepo;
    TrackedMealFoodRepo mealFoodRepo;
    FoodRepository foodRepo;

    private List<MealTimeHistoryDTO> getMealTimeHistory(long clientId) {
//
        List<NutritionalPlan> nutritionalPlans = this.planRepo.findAllByUserId(clientId);

        if (nutritionalPlans.isEmpty())
            return null;

        long nutritionalId = nutritionalPlans.get(nutritionalPlans.size() - 1).getNutritionalPlanId();

        // Se obtiene los mealtimes por nutritionalID
        List<MealTime> mealTimes = mealTimeRepo.findAllByNutritionalPlanId(nutritionalId);
        LocalDate currentDate = LocalDate.now();
        long currentMillis = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        // Se obtienen los mealtimesHistory relacionados con ese nutritionalID y que sea del dia de hoy
        List<MealTimeHistory> history = mealTimeHistoRepo.findByNutritionalPlanId(nutritionalId)
                .stream().filter(m -> m.getDate() >= currentMillis &&
                        m.getDate() < currentMillis + 86_400_000)
                .collect(Collectors.toList());
        List<MealTimeHistoryDTO> result = new ArrayList<>();
        // se mapea la info de las dos entidades en el MealTimeHistoryDTO
        for(MealTime m: mealTimes){ //MealTimes del plan nutricional
            MealTimeHistoryDTO mealDTO = new MealTimeHistoryDTO();
            mealDTO.mealTimeId = m.getMealId();
            mealDTO.nutritionalPlanId = nutritionalId;
            mealDTO.mealType = m.getMealType();
            mealDTO.hour = m.getHour();
            mealDTO.idealcalories = m.getCalories();
            for(MealTimeHistory trackedMeal: history){
                if(trackedMeal.getMealTimeId() == m.getMealId()){
                    mealDTO.mealTimeHistoryId = trackedMeal.getId();
                    mealDTO.totalCalories = trackedMeal.getTotalCalories();
                    mealDTO.date = trackedMeal.getDate();
                    List<TrackedMealFood> list = this.mealFoodRepo.findAllByMealTimeHistoryId(trackedMeal.getId());
                    List<TrackedFoodDTO> foods = this.mealFoodRepo.findAllByMealTimeHistoryId(trackedMeal.getId())
                            .stream().map(TrackedFoodDTO::new).toList();
                    foods.stream().forEach(this::addFoodInfo);
                    mealDTO.foods = foods;
                }
            }
            result.add(mealDTO);
        }
        return result;
    }

    private void addFoodInfo(TrackedFoodDTO dto) {
        Food food = this.foodRepo.findById(dto.foodId).orElseThrow();
        dto.updateFood(food);
    }


    public List<MealTimeHistoryDTO> getClientPlanMealTimeHistory(long clientId){
        return getMealTimeHistory(clientId);
    }

    @Transactional
    public MealTimeHistoryDTO saveMealTimeHistory(MealTimeHistoryDTO dto){
        if (dto.mealTimeHistoryId == null)
            dto.mealTimeHistoryId = -1L;
        long todayMillis = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        MealTimeHistory persisted = this.mealTimeHistoRepo.findById(dto.mealTimeHistoryId).orElseGet(MealTimeHistory::new);
        MealTime meal = this.mealTimeRepo.findById(dto.mealTimeId).orElseThrow();
        NutritionalPlan plan = this.planRepo.findById(meal.getNutritionalPlanId()).orElseThrow();
        persisted.update(dto, plan);
        if (dto.date == 0L)
            persisted.setDate(todayMillis);
        persisted = this.mealTimeHistoRepo.saveAndFlush(persisted);
        mealFoodRepo.deleteAllByMealTimeHistoryId(dto.mealTimeHistoryId);
        List<TrackedFoodDTO> savedFood = new ArrayList<>();
        for (TrackedFoodDTO foodDTO: dto.foods) {
            TrackedMealFood food = new TrackedMealFood();
            food.setMealTimeHistoryId(persisted.getId());
            food.setFoodId(foodDTO.foodId);
            food.setServings(foodDTO.servings);
            food = this.mealFoodRepo.saveAndFlush(food);
            foodDTO.mealTimeHistoryFoodId = food.getTrackedMealId();
            savedFood.add(foodDTO);
        }
        dto.mealTimeHistoryId = persisted.getId();
        dto.foods = savedFood;
        return dto;
    }

}
