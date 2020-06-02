package io.codehunters.commons.web.rest.support.pagination.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationResponse<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;
}