package com.sea.service.consumer.exception;


public enum ResponseEnum {


    BAD_LICENCE_TYPE(7001, "Bad licence type"),

    LICENCE_NOT_FOUND(7002, "Licence not found"),
    ;

    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void throwsException() {
        throw new BusinessException(this.code, this.message);
    }

    public void assertNotNull(Object obj) {
        if (obj == null) {
            throw new BusinessException(this.code, this.message);
        }
    }
}
