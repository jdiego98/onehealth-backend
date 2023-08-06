package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTimeRepository extends JpaRepository<MealTime, Long> {
}
