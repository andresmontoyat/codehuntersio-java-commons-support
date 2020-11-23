package io.codehunters.commons.web.rest.support.pagination.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationResponse<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;
}