package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlusMinus {
    PLUS("입금"),
    MINUS("출금")
    ;

    private final String type;
}
