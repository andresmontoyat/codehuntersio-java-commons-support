package io.codehunters.commons.security.web.authentication;

import io.codehunters.commons.util.ex.ErrorException;

public class DefaultAuthenticationHandlerException extends ErrorException {

    public static final String DEFAULT_ERROR_CODE = "SEC-AUTH-HNDL-ERR";

    public DefaultAuthenticationHandlerException(String message) {
        this(message, DEFAULT_ERROR_CODE);
    }

    public DefaultAuthenticationHandlerException(String message, String code) {
        super(message, code);
    }

    public DefaultAuthenticationHandlerException(String message, Throwable cause) {
        this(message, cause, DEFAULT_ERROR_CODE);
    }

    public DefaultAuthenticationHandlerException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }
}
