package com.kopidev.onehealthbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BodyMeasurements")
public class BodyMeasurement {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long id;
    private double weight;
    private double height;
    private double bmr;
    private double bodyFatPercentage;
    private double bodyFatMass;
    private double asm;
    private double bmi;
    private double tricepSkinfold;
    private double bicepsSkinfold;
    private double subscapulaSkinfold;
    private double suprailiacSkinfold;
    private double chestSkinfold;
    private double thighSkinfold;
    private double legSkinfold;
    private long measurementDate;
    private long userId;
}