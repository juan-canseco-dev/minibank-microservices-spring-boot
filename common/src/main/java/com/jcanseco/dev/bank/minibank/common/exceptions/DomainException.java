package com.jcanseco.dev.bank.minibank.common.exceptions;

public class DomainException extends RuntimeException {
    public DomainException() {}

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }
}
