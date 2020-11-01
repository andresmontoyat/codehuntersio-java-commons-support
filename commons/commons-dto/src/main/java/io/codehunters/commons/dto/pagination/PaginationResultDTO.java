package io.codehunters.commons.dto.pagination;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationResultDTO<T> {

    private List<T> data;

    private long totalRows;

    private int pageSize;

    private int pageNumber;

}
