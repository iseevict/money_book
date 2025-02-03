package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "money_book")
@Builder
@Getter
@Setter
public class MoneyBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content; // 사용 내역

    @Enumerated(EnumType.STRING)
    private PlusMinus plusOrMinus; // 입금 출금

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer price; // 가격

    private LocalDate historyDate; // 사용 날짜

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
