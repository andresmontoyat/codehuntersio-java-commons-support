package io.codehunters.commons.dto.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResultDTO<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;

}
