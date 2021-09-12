package com.sanusi.reginstallmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ApiRequestException.class})
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e) {
        ApiException apiException =new ApiException(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccountNotFoundException.class})
    public ResponseEntity<Object> handlerAccountNotFoundException(AccountNotFoundException e) {
        ApiException apiException =new ApiException(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
