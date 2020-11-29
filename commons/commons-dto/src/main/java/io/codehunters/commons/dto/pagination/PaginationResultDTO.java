package io.codehunters.commons.dto.pagination;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationResultDTO<T> {

    private List<T> data;

    private Long totalRows;

    private Integer pageSize;

    private Integer pageNumber;

}
