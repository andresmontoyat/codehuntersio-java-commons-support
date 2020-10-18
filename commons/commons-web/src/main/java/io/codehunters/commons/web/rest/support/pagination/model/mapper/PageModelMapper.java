package io.codehunters.commons.web.rest.support.pagination.model.mapper;

import io.codehunters.commons.dto.pagination.PageQueryDTO;
import io.codehunters.commons.dto.pagination.PageResultDTO;
import io.codehunters.commons.web.rest.support.pagination.model.PageRequest;
import io.codehunters.commons.web.rest.support.pagination.model.PageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PageModelMapper {

    @Mappings({
            @Mapping(target = "query", source = "query", defaultValue = "*")
    })
    PageQueryDTO toPageQueryDTO(PageRequest pageRequest);

    default PageResponse toPageResponse(PageResultDTO pageResultDTO) {
        return null;
    }
}
