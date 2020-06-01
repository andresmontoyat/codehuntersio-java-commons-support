package io.codehunters.commons.security;

import io.codehunters.commons.util.ex.ErrorException;

@SuppressWarnings("serial")
public class SecurityException extends ErrorException {

    public static final String DEFAULT_ERROR_CODE = "SEC-ERR";

    public SecurityException(String message) {
        this(message, DEFAULT_ERROR_CODE);
    }

    public SecurityException(String message, String code) {
        super(message, code);
    }

    public SecurityException(String message, Throwable cause) {
        this(message, cause, DEFAULT_ERROR_CODE);
    }

    public SecurityException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }
}
