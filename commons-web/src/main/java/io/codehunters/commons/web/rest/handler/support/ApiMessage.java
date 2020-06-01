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
@ApiModel("API Message")
public class ApiMessage<T> extends Message {

    public static final String API_MESSAGE_DEFAULT_CODE = "APM-000000";

    @ApiModelProperty(name = "status")
    @JsonProperty("status")
    private HttpStatus status;

    @ApiModelProperty(name = "data")
    @JsonProperty("data")
    private T data;

    public ApiMessage(String message) {
        this(API_MESSAGE_DEFAULT_CODE, message, HttpStatus.OK);
    }

    public ApiMessage(String message, HttpStatus status) {
        this(API_MESSAGE_DEFAULT_CODE, message, status);
    }

    public ApiMessage(String code, String message, HttpStatus status) {
        super(code, message);
        this.status = status;
    }

    public ApiMessage(String code, String message, HttpStatus status, T data) {
        super(code, message);
        this.status = status;
        this.data = data;
    }
}
