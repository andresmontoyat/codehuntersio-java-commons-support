package io.codehunters.commons.dto.jpa.pagination.support;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationResultDTO<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;

}
