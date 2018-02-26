package com.incremental.ria.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RiaExceptionHandler {

    @ExceptionHandler(RiaException.class)
    public ResponseEntity handleRiaException(RiaException exception) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setExceptionType(exception.getExceptionType());
        exceptionInfo.setMessage(exception.getMessage());

        switch (exception.getExceptionType()) {
            case NOT_FOUND:
                return ResponseEntity.status(404).body(exceptionInfo);
            case UNAUTHORIZED:
            case INVALID_CREDENTIALS:
                return ResponseEntity.status(401).body(exceptionInfo);
            default:
                return null;
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAnyException(Exception exception) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setExceptionType(ExceptionType.INTERNAL_ERROR);
        exceptionInfo.setMessage(exception.getMessage());
        return ResponseEntity.status(500).body(exceptionInfo);
    }
}
