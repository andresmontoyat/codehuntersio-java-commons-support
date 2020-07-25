package io.codehunters.commons.dto.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private String columnOrder;
}
