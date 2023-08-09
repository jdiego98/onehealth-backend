package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealTimeRepository extends JpaRepository<MealTime, Long> {
    List<MealTime> findAllByNutritionalPlanId(long nutritionId);
}
