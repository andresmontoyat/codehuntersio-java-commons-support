package io.codehunters.commons.web.rest.support.pagination.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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