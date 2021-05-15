package io.codehunters.commons.web.rest.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.web.rest.handler.message.support.Api;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiMessage<T> extends Api {

    public static final String API_MESSAGE_DEFAULT_CODE = "API-MSG";

    @JsonProperty("data")
    private T data;

}
