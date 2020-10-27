package io.codehunters.commons.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private List<String> columnsOrder;
}
