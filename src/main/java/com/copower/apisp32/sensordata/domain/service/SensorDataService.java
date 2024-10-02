package com.copower.apisp32.sensordata.domain.service;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import org.springframework.stereotype.Service;

import com.copower.apisp32.sensordata.domain.entity.SensorData;
import com.copower.apisp32.sensordata.infrastructure.repository.SensorDataRepository;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;

     public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }

    public SensorData saveSensorData(SensorData sensorData) {
        sensorData.setTimestamp(LocalDateTime.now());
        return sensorDataRepository.save(sensorData);
    }

    public Map<String, Double> getTodayAverages() {
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);

        Double averageTemperature = sensorDataRepository.findAverageTemperatureForToday(startOfDay, endOfDay);
        Double averageHumidity = sensorDataRepository.findAverageHumidityForToday(startOfDay, endOfDay);

        Map<String, Double> averages = new HashMap<>();
        averages.put("averageTemperature", averageTemperature != null ? averageTemperature : 0.0);
        averages.put("averageHumidity", averageHumidity != null ? averageHumidity : 0.0);

        return averages;
    }

}
