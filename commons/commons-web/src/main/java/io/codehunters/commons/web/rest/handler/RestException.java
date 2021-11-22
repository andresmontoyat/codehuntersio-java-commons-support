package io.codehunters.commons.web.rest.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@SuppressWarnings("serial")
public class RestException extends ContractException {

    public static final String DEFAULT_ERROR_CODE = "API-ERR";

    public RestException(String message, HttpStatus status) {
        super(message, DEFAULT_ERROR_CODE, status, null);
    }

    public RestException(String message, HttpStatus status, List<? extends Object> errors) {
        super(message, DEFAULT_ERROR_CODE, status, errors);
    }

}
