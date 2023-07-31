package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.entity.BodyMeasurement;
import com.kopidev.onehealthbackend.service.BodyMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BodyMeasurementController {
    @Autowired
    private BodyMeasurementService service;

    @RequestMapping(value = "/addBodyMeasurement", method = RequestMethod.POST)
    public BodyMeasurement addbodymeasurement(@RequestBody BodyMeasurement bodyMeasurement){
        return service.saveBodyMeasurement(bodyMeasurement);
    }
}