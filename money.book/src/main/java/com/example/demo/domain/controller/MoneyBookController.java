package com.example.demo.domain.controller;

import com.example.demo.domain.dto.MoneyBookRequestDTO;
import com.example.demo.domain.dto.MoneyBookResponseDTO;
import com.example.demo.domain.service.MoneyBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/money_book")
public class MoneyBookController {

    private final MoneyBookService moneyBookService;

    /**
     * 가게부 작성 API
     */
    @PostMapping("/datas")
    @Operation(summary = "가계부 작성 API",
            description = "가계부에 데이터를 작성하는 API 입니다.<br/><br/>" +
                    "**content**: 가계부 내용<br/><br/>" +
                    "**plusOrMinus**: PLUS(입금) or MINUS(출금)<br/><br/>" +
                    "**price**: 가격<br/><br/>" +
                    "**category**: <br/>" +
                    "&nbsp;TRANSPORT(\"교통비\"),<br/>" +
                    "&nbsp;CONVENIENCE(\"편의점\"),<br/>" +
                    "&nbsp;RESTAURANT(\"식당\"),<br/>" +
                    "&nbsp;CIGARETTE(\"담배\"),<br/>" +
                    "&nbsp;KARAOKE(\"노래방\"),<br/>" +
                    "&nbsp;GIFT(\"선물\"),<br/>" +
                    "&nbsp;DELIVERY(\"배달\"),<br/>" +
                    "&nbsp;COUPANG(\"쿠팡\"),<br/>" +
                    "&nbsp;CAFE(\"카페\"),<br/>" +
                    "&nbsp;ETC(\"기타\")<br/><br/>" +
                    "**historyDate**: 사용 날짜")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공입니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MONTHUSE401", description = "해당 달에 대한 데이터가 존재하지 않습니다.")
    })
    public String inputData(@ModelAttribute MoneyBookRequestDTO.CreateContentRequestDto request, Model model) {
        MoneyBookResponseDTO.CreateContentResponseDto response = moneyBookService.CreateContent(request);
        model.addAttribute("data", response);
        return "moneybookResult";
    }
    /**
     * 타깃 월 사용한 금액 내역 API
     */
    // SELECT id, content, category, plus_or_minus, history_date, year, month FROM money_book WHERE month = mm AND year = yyyy ORDER BY history_date ASC;

    /**
     * 타깃 년도에 사용한 금액 내역 API
     */
    // SELECT id, content, category, plus_or_minus, history_date, year, month FROM money_book WHERE year = yyyy ORDER BY year ASC, history_date ASC;

    /**
     * 타깃 일에 사용한 금액 내역 API
     */
    // SELECT id, content, category, plus_or_minus, history_date, year, month FROM money_book WHERE history_date = 'yyyy/mm/dd' ORDER BY year ASC;

    /**
     * 타깃 일에 사용한 금액
     */
    // SELECT SUM( CASE WHEN plus_or_minus = 'PLUS' THEN price ELSE price * -1 END ) AS total_price FROM money_book WHERE history_date = 'yyyy/mm/dd';

    /**
     * 전체 내역 API (월별 오름차순 / 년도별)
     */
    // SELECT id, content, category, plus_or_minus, history_date, year, month FROM money_book ORDER BY year ASC, history_date ASC;

}
