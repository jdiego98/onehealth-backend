package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.NutritionalPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionalPlanRepository extends JpaRepository<NutritionalPlan, Long> {
    List<NutritionalPlan> findAllByUserId(long id);
}
