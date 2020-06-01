package io.codehunters.commons.web.support.pagination.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest {

    private String query;

    private int page;

    private int size;

    private String order;

    private String columnOrder;
}
