package io.codehunters.commons.service;

import io.codehunters.commons.util.ex.ErrorException;

@SuppressWarnings("serial")
public class ServiceException extends ErrorException {

    public static final String DEFAULT_ERROR_CODE = "SRV-ERR";

    public ServiceException(String message) {
        this(message, DEFAULT_ERROR_CODE);
    }

    public ServiceException(String message, String code) {
        super(message, code);
    }

    public ServiceException(String message, Throwable cause) {
        this(message, cause, DEFAULT_ERROR_CODE);
    }

    public ServiceException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }
}
