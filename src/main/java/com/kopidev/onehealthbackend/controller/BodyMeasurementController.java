package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import com.kopidev.onehealthbackend.service.BodyMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/measures")
public class BodyMeasurementController {
    @Autowired
    private BodyMeasurementService service;

    @RequestMapping(value = "/addBodyMeasurement", method = RequestMethod.POST)
    public BodyMeasurement addbodymeasurement(@RequestBody BodyMeasurement bodyMeasurement){
        return service.saveBodyMeasurement(bodyMeasurement);
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<List<BodyMeasurement>> getUsersBodyMeasurements(@PathVariable long id) {
        return ResponseEntity.ok(this.service.findAllByUserId(id));
    }
}