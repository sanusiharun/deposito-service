package com.sanusi.reginstallmentservice.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

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

    @ExceptionHandler({SavingAccountEmptyException.class})
    public ResponseEntity<Object> handlerSavingAccountEmptyException(SavingAccountEmptyException e) {
        ApiException apiException =new ApiException(HttpStatus.NO_CONTENT, e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(
            Exception ex,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiException apiException =new ApiException(HttpStatus.BAD_REQUEST, details.toString());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
