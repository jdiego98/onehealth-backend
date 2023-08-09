package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.MealTimeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealTimeHistoryRepository extends JpaRepository<MealTimeHistory, Long> {

    @Query(
            value = "select * from oneheatlh.meal_time_history where nutritional_plan_id = :nutritionalPlanId",
            nativeQuery = true
    )
    List<MealTimeHistory> findByNutritionalPlanId(@Param("nutritionalPlanId")long nutritionalPlanId);
}
