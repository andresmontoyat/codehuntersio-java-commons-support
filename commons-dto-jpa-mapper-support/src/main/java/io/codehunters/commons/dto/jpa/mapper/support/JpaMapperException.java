package io.codehunters.commons.dto.jpa.mapper.support;

import io.codehunters.commons.util.ex.ErrorException;

@SuppressWarnings("serial")
public class JpaMapperException extends ErrorException {

    public JpaMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
