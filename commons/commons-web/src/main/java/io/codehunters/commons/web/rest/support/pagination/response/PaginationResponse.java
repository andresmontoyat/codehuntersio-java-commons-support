package io.codehunters.commons.web.rest.support.pagination.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationResponse<T> {

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("rows")
    private Long rows;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("page")
    private Integer page;
}