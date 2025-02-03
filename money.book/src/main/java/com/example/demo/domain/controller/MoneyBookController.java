package com.example.demo.domain.controller;

import com.example.demo.domain.dto.MoneyBookRequestDTO;
import com.example.demo.domain.dto.MoneyBookResponseDTO;
import com.example.demo.domain.service.MoneyBookService;
import com.example.demo.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/money_book")
public class MoneyBookController {

    private final MoneyBookService moneyBookService;

    @PostMapping("/datas")
    @Operation(summary = "가계부 작성 API", description = "가계부에 데이터를 작성하는 API 입니다.")
    public ApiResponse<MoneyBookResponseDTO.CreateContentResponseDto> inputData(@RequestBody MoneyBookRequestDTO.CreateContentRequestDto request) {
        return null;
    }
}
