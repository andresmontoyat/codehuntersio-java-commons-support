package io.codehunters.commons.jpa.mapper;

@SuppressWarnings("serial")
public class MapperJpaException extends RuntimeException {

    public MapperJpaException(String message, Throwable cause) {
        super(message, cause);
    }
}
