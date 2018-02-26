package com.incremental.ria.api.exception;

public class ExceptionInfo {

    private String message;
    private ExceptionType exceptionType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
