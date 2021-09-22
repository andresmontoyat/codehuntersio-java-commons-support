package io.codehunters.commons.web.rest.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.web.rest.handler.message.support.Api;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class ApiError extends Api {

    public static final String API_ERROR_DEFAULT_CODE = "API-ERR";

    @JsonProperty("errors")
    private List errors;

}
