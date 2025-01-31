package com.example.demo.domain.repository;

import com.example.demo.domain.entity.MoneyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyBookRepository extends JpaRepository<MoneyBook, Long> {
}
