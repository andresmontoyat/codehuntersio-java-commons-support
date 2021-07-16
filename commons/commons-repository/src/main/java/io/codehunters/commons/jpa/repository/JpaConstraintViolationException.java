package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.util.ex.ErrorException;

public class JpaConstraintViolationException extends ErrorException {

    public JpaConstraintViolationException(String message, String code) {
        super(message, code);
    }

    public JpaConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JpaConstraintViolationException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }
}
