package io.codehunters.commons.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQueryDTO {

    private String query;

    private int page;

    private int size;

    private String order;

    private String columnOrder;
}
