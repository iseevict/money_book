package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.PlusMinus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MoneyBookRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateContentRequestDto {
        private String content;
        private PlusMinus plusOrMinus;
        private Category category;
        private Integer price;
        private LocalDate historyDate;
    }
}
