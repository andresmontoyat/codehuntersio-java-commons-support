package io.codehunters.commons.web.rest.support;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public interface AbstractRestSupportController {

    default URI createURI(String path, Long id) {
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
}
