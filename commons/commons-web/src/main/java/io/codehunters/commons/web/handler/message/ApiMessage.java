package io.codehunters.commons.web.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codehunters.commons.web.handler.message.support.Api;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class ApiMessage extends Api {

    public static final String API_MESSAGE_DEFAULT_CODE = "API-MSG";

    @JsonProperty("data")
    private Object data;

}
