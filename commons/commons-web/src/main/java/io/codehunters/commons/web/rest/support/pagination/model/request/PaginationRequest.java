package io.codehunters.commons.web.rest.support.pagination.model.request;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationRequest {

    private String query;

    private int page;

    private int size;

    private Map<String, String> columns;
}
