package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
    List<BodyMeasurement> findAllByUserId(long id);
}
