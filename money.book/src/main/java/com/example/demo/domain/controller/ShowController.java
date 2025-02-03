package com.example.demo.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

    @GetMapping("/moneybook/form")
    public String ShowMoneyBookForm() {
        return "moneybookForm";
    }
}
