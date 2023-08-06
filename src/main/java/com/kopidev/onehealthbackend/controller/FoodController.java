package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.dto.FoodDTO;
import com.kopidev.onehealthbackend.entity.Food;
import com.kopidev.onehealthbackend.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food") @AllArgsConstructor
public class FoodController {

    final FoodService service;

    @PostMapping(value = "add")
    public ResponseEntity<Object> addFood(@RequestBody FoodDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        return ResponseEntity.ok(this.service.getAll());
    }


    @PostMapping(value = "all")
    public ResponseEntity<Object> addAllFood(@RequestBody List<FoodDTO> dto) {
        service.saveAll(dto);
        return ResponseEntity.ok("Listo");
    }

}
