package com.example.demo.domain.repository;

import com.example.demo.domain.entity.MonthUse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthUseRepository extends JpaRepository<MonthUse, Long> {
    Optional<MonthUse> findByMonth(String month);
}
