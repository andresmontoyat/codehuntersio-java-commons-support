package io.codehunters.commons.security.web.authentication;

import io.codehunters.commons.util.ex.ErrorException;

public class DefaultAuthenticationHandlerException extends ErrorException {

    public DefaultAuthenticationHandlerException(String message) {
        super(message);
    }

    public DefaultAuthenticationHandlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
