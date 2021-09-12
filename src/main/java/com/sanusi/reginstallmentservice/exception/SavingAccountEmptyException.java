package com.sanusi.reginstallmentservice.exception;

public class SavingAccountEmptyException extends RuntimeException {

    public SavingAccountEmptyException(String message) {
        super(message);
    }

    public SavingAccountEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}


