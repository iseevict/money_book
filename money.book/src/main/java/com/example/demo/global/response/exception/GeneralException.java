package com.example.demo.global.response.exception;

import com.example.demo.global.response.code.BaseErrorCode;
import com.example.demo.global.response.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode errorCode;

    public ErrorReasonDTO getErrorReason() {
        return this.errorCode.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.errorCode.getReasonHttpStatus();
    }
}
