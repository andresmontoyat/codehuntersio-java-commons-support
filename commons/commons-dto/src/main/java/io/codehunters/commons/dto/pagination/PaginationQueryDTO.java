package io.codehunters.commons.dto.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

/**
 * @author andres.montoya@codehunters.io
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class PaginationQueryDTO {

    private String query;

    private Integer page;

    private Integer size;

    private Map<String, String> columns;
}
