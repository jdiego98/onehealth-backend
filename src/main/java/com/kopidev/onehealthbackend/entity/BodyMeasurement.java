package com.kopidev.onehealthbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BodyMeasurement")
public class BodyMeasurement {
    @Id
    @GeneratedValue
    private long id;
    private long weight;
    private long height;
    private long bmr;
    private long bodyFatPercentage;
    private long bodyFatMass;
    private long asm;
    private long bmi;
    private long tricepSkinfold;
    private long bicepsSkinfold;
    private long subscapulaSkinfold;
    private long suprailiacSkinfold;
    private long chestSkinfold;
    private long thighSkinfold;
    private long legSkinfold;
    private long measurementDate;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}