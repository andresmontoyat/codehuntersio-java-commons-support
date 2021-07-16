package io.codehunters.commons.util.ex;

import lombok.Getter;

@Getter
public abstract class ErrorException extends RuntimeException {

    public static final String DEFAULT_ERROR_CODE = "ERR";

    protected final String code;

    protected ErrorException(String message) {
        this(message, DEFAULT_ERROR_CODE);
    }

    protected ErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    protected ErrorException(String message, Throwable cause) {
        this(message, DEFAULT_ERROR_CODE, cause);
    }

    protected ErrorException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}