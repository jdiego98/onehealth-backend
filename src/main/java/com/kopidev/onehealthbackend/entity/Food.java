package com.kopidev.onehealthbackend.entity;

import com.kopidev.onehealthbackend.dto.FoodDTO;
import com.kopidev.onehealthbackend.enums.Measurements;
import com.kopidev.onehealthbackend.enums.Nutrients;
import com.kopidev.onehealthbackend.enums.PrivacyOptions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity @Table(name = "FOODS") @Getter @Setter
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long foodId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Measurements measure;
    private float serving;
    private float carbs;
    private float protein;
    private float fat;
    private Integer calories;
    private Long creator;
    @Enumerated(EnumType.STRING)
    private PrivacyOptions privacy;
    @Enumerated(EnumType.STRING)
    private Nutrients clasification;

    public void update(FoodDTO dto) {
        this.name = dto.name;
        this.measure = Measurements.valueOf(dto.measure);
        this.serving = dto.serving;
        this.carbs = dto.carbs;
        this.protein = dto.protein;
        this.fat = dto.fat;
        this.calories = dto.calories;
        this.creator = dto.creator;
        this.privacy = PrivacyOptions.valueOf(dto.privacy);
        this.clasification = Nutrients.valueOf(dto.clasification);
    }
}
