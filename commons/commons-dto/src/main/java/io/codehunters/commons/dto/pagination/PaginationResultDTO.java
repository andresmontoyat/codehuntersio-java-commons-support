package io.codehunters.commons.dto.pagination;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class PaginationResultDTO<T> {

    private List<T> data;

    private Long rows;

    private Integer page;

    private Integer size;
}
