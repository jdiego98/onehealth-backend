package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
}
