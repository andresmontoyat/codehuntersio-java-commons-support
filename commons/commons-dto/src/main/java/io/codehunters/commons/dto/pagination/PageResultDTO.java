package io.codehunters.commons.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultDTO<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;

}
