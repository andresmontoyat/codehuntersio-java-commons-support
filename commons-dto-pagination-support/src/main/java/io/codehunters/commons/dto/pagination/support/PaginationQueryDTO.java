package io.codehunters.commons.dto.pagination.support;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PaginationQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private String columnOrder;
}
