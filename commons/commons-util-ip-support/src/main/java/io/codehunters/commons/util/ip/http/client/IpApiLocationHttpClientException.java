package io.codehunters.commons.util.ip.http.client;

public class IpApiLocationHttpClientException extends RuntimeException {

    public IpApiLocationHttpClientException(String message) {
        super(message);
    }

    public IpApiLocationHttpClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
