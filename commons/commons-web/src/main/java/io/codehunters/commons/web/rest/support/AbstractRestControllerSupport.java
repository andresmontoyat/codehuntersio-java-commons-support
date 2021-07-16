package io.codehunters.commons.web.rest.support;

import io.codehunters.commons.web.rest.handler.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public interface AbstractRestControllerSupport {

    default URI createURI(String path, Object id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(id)
                .toUri();
    }

    default URI createURI(String path, Map<String, ? extends Object> vars) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(vars)
                .toUri();
    }

    default void defaultBindingResultHasErrors(BindingResult result, HttpStatus httpStatus, String message){
        if(result.hasErrors())
            throw new RestException(message, httpStatus, result.getAllErrors());
    }

}
