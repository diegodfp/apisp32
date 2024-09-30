package com.copower.apisp32.sensordata.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.copower.apisp32.sensordata.domain.entity.SensorData;
import com.copower.apisp32.sensordata.domain.service.SensorDataService;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {
    private final SensorDataService sensorDataService;
    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return sensorDataService.getAllSensorData();
    }

    @PostMapping
    public ResponseEntity<SensorData> createSensorData(@RequestBody SensorData sensorData) {
        SensorData savedData = sensorDataService.saveSensorData(sensorData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }
}
