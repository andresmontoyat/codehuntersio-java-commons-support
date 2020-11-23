package io.codehunters.commons.dto.pagination;

import lombok.*;

import java.util.Map;

/**
 * @author andres.montoya@codehunters.io
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationQueryDTO {

    private String query;

    private int page;

    private int size;

    private Map<String, String> columns;
}
