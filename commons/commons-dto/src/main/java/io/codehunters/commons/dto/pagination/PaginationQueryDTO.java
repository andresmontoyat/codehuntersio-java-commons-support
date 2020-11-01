package io.codehunters.commons.dto.pagination;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private List<String> columnsOrder;
}
