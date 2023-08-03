package com.holdem.airline.airline.common.exception;

import com.holdem.airline.airline.common.response.ErrorCode;
import lombok.Getter;

/**
 * AirlineException 또는 AirlineException 을 확장한 Exception 은
 * 서비스 운영에서 예상이 가능한 Exception 을 표현한다.
 *
 * 그렇기 때문에 http status: 200 이면서 result: FAIL 을 표현하고
 * 특정 ErrorCode 만 alert 를 포함한 모니터링 대상으로 한다.
 */
@Getter
public class AirlineException extends RuntimeException {
    private ErrorCode errorCode;

    public AirlineException() {
    }

    public AirlineException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public AirlineException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AirlineException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
