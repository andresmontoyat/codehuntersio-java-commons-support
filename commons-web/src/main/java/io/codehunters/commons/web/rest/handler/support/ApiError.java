package io.codehunters.commons.web.rest.handler.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.util.ex.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ApiModel("API Error Message")
public class ApiError<T> extends Message {

    public static final String API_ERROR_DEFAULT_CODE = "000000";

    @ApiModelProperty(name = "status")
    @JsonProperty("status")
    private HttpStatus status;

    @ApiModelProperty(name = "errors")
    @JsonProperty("errors")
    private T errors;

    public ApiError(String message) {
        this(API_ERROR_DEFAULT_CODE, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ApiError(String message, HttpStatus status) {
        this(API_ERROR_DEFAULT_CODE, message, status);
    }

    public ApiError(String code, String message, HttpStatus status) {
        super(code, message);
        this.status = status;
    }

    public ApiError(String code, String message, HttpStatus status, T errors) {
        this(code, message, status);
        this.errors = errors;
    }

}
