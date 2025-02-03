package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.PlusMinus;
import lombok.*;

import java.time.LocalDate;

public class MoneyBookRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class CreateContentRequestDto {
        private String content;
        private PlusMinus plusOrMinus;
        private Category category;
        private Integer price;
        private LocalDate historyDate;
    }
}
