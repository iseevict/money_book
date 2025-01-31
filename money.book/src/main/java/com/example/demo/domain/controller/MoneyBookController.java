package com.example.demo.domain.controller;

import com.example.demo.domain.repository.MoneyBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/money_book")
public class MoneyBookController {

    private final MoneyBookService moneyBookService;

    @PostMapping("/datas")
    public void inputData() {

    }
}
