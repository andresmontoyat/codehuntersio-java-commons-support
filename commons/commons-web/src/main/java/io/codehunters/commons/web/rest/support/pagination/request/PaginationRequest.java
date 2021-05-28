package io.codehunters.commons.web.rest.support.pagination.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationRequest {

    private String query;

    @NotNull
    @PositiveOrZero
    private Integer page;

    @NotNull
    @PositiveOrZero
    private Integer size;

    private Map<String, String> sort;
}