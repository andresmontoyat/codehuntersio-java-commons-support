package io.codehunters.commons.web.rest.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.web.rest.handler.message.support.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ApiModel("API Error Message")
public class ApiError<T> extends Api {

    public static final String API_ERROR_DEFAULT_CODE = "API-ERR-000000";

    @ApiModelProperty(name = "errors")
    @JsonProperty("errors")
    private T errors;

    public ApiError(String code, String message, HttpStatus status) {
        super(code, message, status);
    }

    public ApiError(String code, String message, HttpStatus status, T errors) {
        super(code, message, status);
        this.errors = errors;
    }

}
