package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
    List<BodyMeasurement> findAllByUserId(long id);

    @Query(
            value = "SELECT * FROM body_measurements WHERE user_id = :id ORDER BY measurement_date DESC LIMIT 1",
            nativeQuery = true
    )
    BodyMeasurement findLatestByUserId(long id);
}
