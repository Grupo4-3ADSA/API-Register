package com.autog.register.repository;

import com.autog.register.entity.TemperatureSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensor, Integer> {
}
