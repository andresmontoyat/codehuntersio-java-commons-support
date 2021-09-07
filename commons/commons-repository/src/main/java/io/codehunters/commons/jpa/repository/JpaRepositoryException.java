package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.util.ex.ErrorException;

public class JpaRepositoryException extends ErrorException {

    public static final String DEFAULT_REPOSITORY_ERROR_MESSAGE = "An error has occurred trying to access database.";

    public JpaRepositoryException(String message, String code) {
        super(message, code);
    }

    public JpaRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public JpaRepositoryException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }
}
