package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    TRANSPORT("교통비"),
    CONVENIENCE("편의점"),
    RESTAURANT("식당"),
    CIGARETTE("담배"),
    KARAOKE("노래방"),
    GIFT("선물"),
    DELIVERY("배달"),
    COUPANG("쿠팡"),
    CAFE("카페"),
    ETC("기타")
    ;

    private final String category;
}
