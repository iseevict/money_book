package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "money_book")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    private Integer year; // 사용 년도

    private Integer month; // 사용 월

    private LocalDate historyDate; // 사용 날짜

    @CreatedDate
    @Setter
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Setter
    private LocalDateTime updatedAt;
}
