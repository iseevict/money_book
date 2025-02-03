package com.example.demo.domain.converter;

import com.example.demo.domain.dto.MoneyBookRequestDTO;
import com.example.demo.domain.dto.MoneyBookResponseDTO;
import com.example.demo.domain.entity.MoneyBook;

import java.time.LocalDateTime;

public class MoneyBookConverter {
    public static MoneyBookResponseDTO.CreateContentResponseDto ToCreateContentResponseDto (MoneyBook moneyBook, Integer categoryNum, Integer totalUse) {
        return MoneyBookResponseDTO.CreateContentResponseDto.builder()
                .id(moneyBook.getId())
                .content(moneyBook.getContent())
                .price(moneyBook.getPrice())
                .plusOrMinus(moneyBook.getPlusOrMinus())
                .category(moneyBook.getCategory())
                .categoryNum(categoryNum)
                .totalUse(totalUse)
                .historyDate(moneyBook.getHistoryDate())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MoneyBook ToMoneyBook (MoneyBookRequestDTO.CreateContentRequestDto request) {
        return MoneyBook.builder()
                .price(request.getPrice())
                .content(request.getContent())
                .plusOrMinus(request.getPlusOrMinus())
                .category(request.getCategory())
                .historyDate(request.getHistoryDate())
                .build();
    }
}
