package io.codehunters.commons.web.rest.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.web.rest.handler.message.support.Api;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError<T> extends Api {

    public static final String API_ERROR_DEFAULT_CODE = "API-ERR";

    @JsonProperty("errors")
    private T errors;

}
