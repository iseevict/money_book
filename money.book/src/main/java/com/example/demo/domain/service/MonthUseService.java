package com.example.demo.domain.service;

import com.example.demo.domain.entity.MonthUse;
import com.example.demo.domain.repository.MonthUseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MonthUseService {

    private final MonthUseRepository monthUseRepository;

    /**
     * 애플리케이션 실행 시 한 번 실행됨
     * 매달 1일 정각에 애플리케이션이 구동중인 상황에 한 번 실행됨
     * 만약 MonthUse 테이블에 해당 달에 대한 컬럼이 없을 경우 추가하는 메서드
     */
    @PostConstruct
    @Scheduled(cron = "1 0 0 1 * ?")
    @Transactional
    public void checkMonthColumn() {
        System.out.println("MonthUse 테이블 체크 작업 진행 중...");
        LocalDate now = LocalDate.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM");
        String month = now.format(dateFormat);

        if (monthUseRepository.findByMonth(month).isEmpty()) {
            MonthUse newMonthUse = MonthUse.builder()
                    .month(month)
                    .usePrice(0)
                    .build();

            monthUseRepository.save(newMonthUse);
        }
        System.out.println("체크 작업 완료..");
    }
}
