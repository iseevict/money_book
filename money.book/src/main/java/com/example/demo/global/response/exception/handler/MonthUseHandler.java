package com.example.demo.global.response.exception.handler;

import com.example.demo.global.response.code.BaseErrorCode;
import com.example.demo.global.response.exception.GeneralException;

public class MonthUseHandler extends GeneralException {
    public MonthUseHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
