package io.codehunters.commons.web.rest.support.pagination.model.mapper;

import io.codehunters.commons.dto.jpa.pagination.support.PaginationQueryDTO;
import io.codehunters.commons.dto.jpa.pagination.support.PaginationResultDTO;
import io.codehunters.commons.web.rest.support.pagination.model.PaginationRequest;
import io.codehunters.commons.web.rest.support.pagination.model.PaginationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaginationModelMapper {

    PaginationQueryDTO toPaginationQuery(PaginationRequest paginationRequest);

    default PaginationResponse toPaginationResponse(PaginationResultDTO paginationResultDTO) {
        return null;
    }
}
