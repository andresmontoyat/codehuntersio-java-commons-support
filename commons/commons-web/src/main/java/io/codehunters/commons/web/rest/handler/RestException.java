package io.codehunters.commons.web.rest.handler;

import io.codehunters.commons.util.ex.ErrorException;
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
        this(message, DEFAULT_ERROR_CODE, status, null);
    }

    public RestException(String message, String code, HttpStatus status) {
        this(message, code, status, null);
    }

    public RestException(String message, String code, HttpStatus status, List errors) {
        super(message, code);

        this.status = status;
        this.errors = errors;
    }

    public RestException(String message, Throwable cause, HttpStatus status) {
        this(message, DEFAULT_ERROR_CODE, cause, status, null);
    }

    public RestException(String message, String code, Throwable cause, HttpStatus status) {
        this(message, code, cause, status, null);
    }

    public RestException(String message, String code, Throwable cause, HttpStatus status, List errors) {
        super(message, code, cause);

        this.status = status;
        this.errors = errors;
    }
}
