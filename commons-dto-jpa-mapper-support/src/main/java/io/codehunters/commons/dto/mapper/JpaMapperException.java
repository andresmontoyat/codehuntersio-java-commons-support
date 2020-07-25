package io.codehunters.commons.dto.mapper;

import io.codehunters.commons.ex.ErrorException;

@SuppressWarnings("serial")
public class JpaMapperException extends ErrorException {

    public JpaMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
