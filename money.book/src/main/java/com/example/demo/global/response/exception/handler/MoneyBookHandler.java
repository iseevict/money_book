package com.example.demo.global.response.exception.handler;

import com.example.demo.global.response.code.BaseErrorCode;
import com.example.demo.global.response.exception.GeneralException;

public class MoneyBookHandler extends GeneralException {
    public MoneyBookHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
