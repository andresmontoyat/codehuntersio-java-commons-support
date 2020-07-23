package io.codehunters.commons.web.rest.handler.message.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.util.ex.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ApiModel("API Object")
public abstract class Api extends Message {

    @ApiModelProperty(name = "status")
    @JsonProperty("status")
    private HttpStatus status;

    public Api(String code, String message, HttpStatus status) {
        super(code, message);
        this.status = status;
    }
}
