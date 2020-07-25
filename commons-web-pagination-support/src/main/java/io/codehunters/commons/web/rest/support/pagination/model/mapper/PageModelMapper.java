package io.codehunters.commons.web.rest.support.pagination.model.mapper;

import io.codehunters.commons.dto.pagination.PageQueryDTO;
import io.codehunters.commons.dto.pagination.PageResultDTO;
import io.codehunters.commons.web.rest.support.pagination.model.PageRequest;
import io.codehunters.commons.web.rest.support.pagination.model.PageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PageModelMapper {

    PageQueryDTO toPageQueryDTO(PageRequest pageRequest);

    default PageResponse toPageResponse(PageResultDTO pageResultDTO) {
        return null;
    }
}
