package com.copower.apisp32.sensordata.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {


     private int updateInterval = 5000; 

    @GetMapping("/interval")
    public int getUpdateInterval() {
        return updateInterval;
    }

    @PostMapping("/interval")
    public ResponseEntity<String> setUpdateInterval(@RequestParam int interval) {
        this.updateInterval = interval;
        return ResponseEntity.ok("Intervalo de actualización modificado a " + interval + " ms");
    }
}