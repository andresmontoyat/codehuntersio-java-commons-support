package io.codehunters.commons.web.rest.handler;

import io.codehunters.commons.ex.ErrorException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@SuppressWarnings("serial")
public class RestException extends ErrorException {

    public static final String DEFAULT_ERROR_CODE = "API-ERR";

    private HttpStatus status;

    private List errors;

    public RestException(String message, HttpStatus status) {
        this(message, status, DEFAULT_ERROR_CODE, null);
    }

    public RestException(String message, HttpStatus status, String code) {
        this(message, status, code, null);
    }

    public RestException(String message, HttpStatus status, String code, List errors) {
        super(message, code);

        this.status = status;
        this.errors = errors;
    }

    public RestException(String message, Throwable cause, HttpStatus status) {
        this(message, cause, status, DEFAULT_ERROR_CODE, null);
    }

    public RestException(String message, Throwable cause, HttpStatus status, String code) {
        this(message, cause, status, code, null);
    }

    public RestException(String message, Throwable cause, HttpStatus status, String code, List errors) {
        super(message, cause, code);

        this.status = status;
        this.errors = errors;
    }

}
