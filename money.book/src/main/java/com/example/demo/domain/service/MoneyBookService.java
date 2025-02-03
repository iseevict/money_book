package com.example.demo.domain.service;

import com.example.demo.domain.converter.MoneyBookConverter;
import com.example.demo.domain.dto.MoneyBookRequestDTO;
import com.example.demo.domain.dto.MoneyBookResponseDTO;
import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.MoneyBook;
import com.example.demo.domain.repository.MoneyBookRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoneyBookService {

    private final MoneyBookRepository moneyBookRepository;

    /**
     * 새로운 데이터 추가하는 메서드
     *
     */
    @Transactional
    public MoneyBookResponseDTO.CreateContentResponseDto CreateContent(MoneyBookRequestDTO.CreateContentRequestDto request) {
        MoneyBook newMoneyBook = MoneyBookConverter.ToMoneyBook(request);
        moneyBookRepository.save(newMoneyBook);

        Integer categoryNum = GetCategoryDataNum(newMoneyBook.getCategory());

    }

    private Integer GetCategoryDataNum (Category category) {
        return moneyBookRepository.countByCategory(category);
    }
}
