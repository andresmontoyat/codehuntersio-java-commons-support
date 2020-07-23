package io.codehunters.commons.dto.jpa.pagination.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private String columnOrder;
}
