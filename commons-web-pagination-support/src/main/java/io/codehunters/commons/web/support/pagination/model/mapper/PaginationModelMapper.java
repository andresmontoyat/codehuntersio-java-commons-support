package io.codehunters.commons.web.support.pagination.model.mapper;

import io.codehunters.commons.dto.pagination.support.PaginationQueryDTO;
import io.codehunters.commons.dto.pagination.support.PaginationResultDTO;
import io.codehunters.commons.web.support.pagination.model.PaginationRequest;
import io.codehunters.commons.web.support.pagination.model.PaginationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaginationModelMapper {

    PaginationQueryDTO toPaginationQuery(PaginationRequest paginationRequest);

    default PaginationResponse toPaginationResponse(PaginationResultDTO paginationResultDTO) {
        return null;
    }
}
