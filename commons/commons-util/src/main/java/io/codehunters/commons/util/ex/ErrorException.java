package io.codehunters.commons.util.ex;

public abstract class ErrorException extends RuntimeException {

    public static final String DEFAULT_ERROR_CODE = "ERR";

    private String code;

    public ErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ErrorException(String message, Throwable cause) {
        this(message, DEFAULT_ERROR_CODE, cause);
    }

    public ErrorException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}