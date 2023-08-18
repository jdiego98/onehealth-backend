package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import com.kopidev.onehealthbackend.repository.BodyMeasurementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BodyMeasurementService {
    @Autowired
    private BodyMeasurementRepository repository;

    public BodyMeasurement saveBodyMeasurement(BodyMeasurement bodyMeasurement){
        return repository.save(bodyMeasurement);
    }

    public List<BodyMeasurement> findAllByUserId(long id) {
        return repository.findAllByUserId(id);
    }

    public BodyMeasurement findLatestByUserId(long id) {
        return repository.findLatestByUserId(id);
    }
}
