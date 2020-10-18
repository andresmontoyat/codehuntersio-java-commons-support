package io.codehunters.commons.jpa.mapper;

@SuppressWarnings("serial")
public class JpaMapperException extends RuntimeException {

    public JpaMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
