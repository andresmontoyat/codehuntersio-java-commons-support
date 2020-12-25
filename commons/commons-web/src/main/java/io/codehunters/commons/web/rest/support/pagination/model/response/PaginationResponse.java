package io.codehunters.commons.web.rest.support.pagination.model.response;

import io.swagger.models.auth.In;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationResponse<T> {

    private List<T> data;

    private Long rows;

    private Integer size;

    private Integer page;
}