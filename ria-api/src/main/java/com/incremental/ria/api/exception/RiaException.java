package com.incremental.ria.api.exception;

public class RiaException extends RuntimeException {

    private ExceptionType exceptionType;

    public RiaException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}
