package com.copower.apisp32.sensordata.infrastructure.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.copower.apisp32.sensordata.domain.entity.SensorData;



public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    
     @Query("SELECT AVG(sd.temperature) FROM SensorData sd WHERE sd.timestamp >= :startOfDay AND sd.timestamp < :endOfDay")
    Double findAverageTemperatureForToday(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);

    @Query("SELECT AVG(sd.humidity) FROM SensorData sd WHERE sd.timestamp >= :startOfDay AND sd.timestamp < :endOfDay")
    Double findAverageHumidityForToday(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);
    
}

