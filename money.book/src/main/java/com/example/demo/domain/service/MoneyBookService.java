package com.example.demo.domain.service;

import com.example.demo.domain.converter.MoneyBookConverter;
import com.example.demo.domain.dto.MoneyBookRequestDTO;
import com.example.demo.domain.dto.MoneyBookResponseDTO;
import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.MoneyBook;
import com.example.demo.domain.entity.MonthUse;
import com.example.demo.domain.entity.PlusMinus;
import com.example.demo.domain.repository.MoneyBookRepository;
import com.example.demo.domain.repository.MonthUseRepository;
import com.example.demo.global.response.code.resultCode.ErrorStatus;
import com.example.demo.global.response.exception.handler.MonthUseHandler;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoneyBookService {

    private final MoneyBookRepository moneyBookRepository;
    private final MonthUseRepository monthUseRepository;

    /**
     * 새로운 데이터 추가하는 메서드
     *
     */
    @Transactional
    public MoneyBookResponseDTO.CreateContentResponseDto CreateContent(MoneyBookRequestDTO.CreateContentRequestDto request) {
        MoneyBook newMoneyBook = MoneyBookConverter.ToMoneyBook(request, request.getHistoryDate().getYear(), request.getHistoryDate().getMonthValue());
        moneyBookRepository.save(newMoneyBook);

        UpdateMonthUsePrice(newMoneyBook);

        Integer categoryNum = GetCategoryDataNum(newMoneyBook);
        Integer dayUse = GetDayUse(newMoneyBook);

        return MoneyBookConverter.ToCreateContentResponseDto(newMoneyBook, categoryNum, dayUse);
    }

    /**
     * 해당 달에 대한 가격 업데이트 메서드
     */
    @Transactional
    private void UpdateMonthUsePrice(MoneyBook moneyBook) {
        LocalDate historyDate = moneyBook.getHistoryDate();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM");
        String month = historyDate.format(dateFormat);

        MonthUse nowMonthUse = monthUseRepository.findByMonth(month)
                .orElseThrow(() -> new MonthUseHandler(ErrorStatus.NOT_EXIST_MONTH_USE));

        if (moneyBook.getPlusOrMinus() == PlusMinus.PLUS) {
            nowMonthUse.updateUsePrice(moneyBook.getPrice());
        }
        else nowMonthUse.updateUsePrice(-moneyBook.getPrice());

        monthUseRepository.save(nowMonthUse);
    }

    /**
     * 해당 달에 카테고리에 대한 비용 지불 횟수 리턴 메서드
     */
    private Integer GetCategoryDataNum (MoneyBook moneyBook) {
        return moneyBookRepository.countByCategoryAndYearAndMonth(moneyBook.getCategory(), moneyBook.getYear(), moneyBook.getMonth());
    }

    /**
     * 해당 일에 사용한 총 비용 리턴 메서드
     */
    private Integer GetDayUse (MoneyBook moneyBook) {
        int total = 0;
        List<MoneyBook> moneyBookList = moneyBookRepository.findAllByHistoryDate(moneyBook.getHistoryDate())
                .orElse(new ArrayList<>());

        for (MoneyBook nowMoneyBook : moneyBookList) {
            if (nowMoneyBook.getPlusOrMinus() == PlusMinus.PLUS) {
                total += nowMoneyBook.getPrice();
            }
            else total -= nowMoneyBook.getPrice();
        }

        return total;
    }
}
