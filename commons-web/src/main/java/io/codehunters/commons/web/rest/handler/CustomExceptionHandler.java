package io.codehunters.commons.web.rest.handler;

import io.codehunters.commons.service.ServiceException;
import io.codehunters.commons.web.rest.handler.support.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@SuppressWarnings("unchecked")
public class CustomExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiError> resolveServiceException(HttpServletRequest request, HttpServletResponse response, ServiceException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(e.getCode(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ApiError> resolveRestException(HttpServletRequest request, HttpServletResponse response, RestException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(e.getStatus()).body(new ApiError(e.getCode(), e.getMessage(), e.getStatus(), e.getErrors()));
    }
}
