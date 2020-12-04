package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.util.ex.ErrorException;

public class RepositoryException extends ErrorException {

    public RepositoryException(String message, String code) {
        super(message, code);
    }

    public RepositoryException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }
}
