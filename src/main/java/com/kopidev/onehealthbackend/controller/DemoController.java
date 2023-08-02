package com.kopidev.onehealthbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping(value = "/ping")
    public ResponseEntity<Object> healthCheck(){
        return ResponseEntity.ok("Saludos desde OneHealth API");
    }
}
