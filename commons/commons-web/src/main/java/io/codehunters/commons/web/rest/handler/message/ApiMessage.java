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
@ApiModel("API Message")
public class ApiMessage<T> extends Api {

    public static final String API_MESSAGE_DEFAULT_CODE = "API-MSG-000000";

    @ApiModelProperty(name = "data")
    @JsonProperty("data")
    private T data;

    public ApiMessage(String code, String message, HttpStatus status) {
        super(code, message, status);
    }

    public ApiMessage(String code, String message, HttpStatus status, T data) {
        super(code, message, status);
        this.data = data;
    }
}
