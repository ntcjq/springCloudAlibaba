package com.sea.service.consumer.exception;

public class BusinessException extends RuntimeException {

    private int code;

    BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

}
