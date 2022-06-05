package com.autog.register.repository;

import com.autog.register.entity.RateValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface RateValueRepository extends JpaRepository<RateValue, Integer> {

    RateValue findByDateBetween(LocalDateTime data1, LocalDateTime date2);
}
