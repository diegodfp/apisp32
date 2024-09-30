package com.copower.apisp32.sensordata.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.copower.apisp32.sensordata.domain.entity.SensorData;



public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

}

