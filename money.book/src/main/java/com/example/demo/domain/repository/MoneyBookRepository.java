package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.MoneyBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MoneyBookRepository extends JpaRepository<MoneyBook, Long> {
    Integer countByCategoryAndYearAndMonth(Category category, Integer year, Integer month);
    Optional<List<MoneyBook>> findAllByHistoryDate(LocalDate historyDate);
}
