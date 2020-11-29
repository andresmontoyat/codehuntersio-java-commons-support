package io.codehunters.commons.jpa.repository.converter.support;

@SuppressWarnings("serial")
public class DomainAttributeConverterException extends RuntimeException {

    public DomainAttributeConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
