package io.codehunters.commons.dto.pagination.support.mapper;

import io.codehunters.commons.dto.mapper.support.DTOMapper;
import io.codehunters.commons.dto.pagination.support.PaginationQueryDTO;
import io.codehunters.commons.dto.pagination.support.PaginationResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SuppressWarnings("unchecked")
public interface PaginationDTOMapper<D, E> extends DTOMapper<D, E> {

    default PageRequest toPageRequest(PaginationQueryDTO paginationQuery) {
        return PageRequest.of(paginationQuery.getPage(), Math.min(1000, paginationQuery.getSize()), Sort.by(Sort.Direction.fromString(paginationQuery.getOrder()), paginationQuery.getColumnOrder()));
    }

    default String replaceQuery(PaginationQueryDTO paginationQuery) {
        String query = paginationQuery.getQuery();
        return String.format("%s%%", ("".equals(query) || "*".equals(query)) ? "%" : query);
    }

    default PaginationResultDTO toPaginationResult(Page page) {
        PaginationResultDTO result = new PaginationResultDTO();
        result.setData(toDTOS(page.getContent()));
        result.setTotalRows(page.getTotalElements());
        result.setPageSize(page.getSize());
        result.setPageNumber(page.getNumber());
        return result;
    }
}
