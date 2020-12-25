package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.util.ex.ErrorException;

public class JpaRepositoryException extends ErrorException {

    public JpaRepositoryException(String message, String code) {
        super(message, code);
    }

    public JpaRepositoryException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }
}
