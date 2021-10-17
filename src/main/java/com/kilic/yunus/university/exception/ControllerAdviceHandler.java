package com.kilic.yunus.university.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> dataIntegrityViolationExceptionHandler(
            RuntimeException ex, WebRequest request) {
        DataIntegrityViolationException violationException = (DataIntegrityViolationException) ex;
        String bodyOfResponse = violationException.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
