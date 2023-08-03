package com.codingtest.rgt.common.exception;

import com.codingtest.rgt.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class RgtException extends RuntimeException {
    private ErrorCode errorCode;

    public RgtException() {
    }

    public RgtException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public RgtException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RgtException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
