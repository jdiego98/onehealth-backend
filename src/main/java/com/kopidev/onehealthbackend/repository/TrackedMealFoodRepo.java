package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.TrackedMealFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackedMealFoodRepo extends JpaRepository<TrackedMealFood, Long> {
    List<TrackedMealFood> findAllByMealTimeHistoryId(long mealTimeId);

}
