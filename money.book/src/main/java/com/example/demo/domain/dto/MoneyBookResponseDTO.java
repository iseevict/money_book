package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.PlusMinus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MoneyBookResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateContentResponseDto {
        private Long id;
        private String content;
        private Integer price;
        private PlusMinus plusOrMinus;
        private Category category;
        private Integer categoryNum;
        private Integer dayUse;
        private Integer year;
        private Integer month;
        private LocalDate historyDate;
        private LocalDateTime createdAt;
    }
}
