package io.codehunters.commons.jpa.mapper.pagination;

import io.codehunters.commons.jpa.mapper.DTOMapper;
import io.codehunters.commons.dto.pagination.PaginationQueryDTO;
import io.codehunters.commons.dto.pagination.PaginationResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SuppressWarnings("unchecked")
public interface PaginationJpaMapper<D, E> extends DTOMapper<D, E> {

    default PageRequest toPageRequest(PaginationQueryDTO paginationQuery) {
        return PageRequest.of(paginationQuery.getPage(), Math.min(1000, paginationQuery.getSize()), Sort.by(Sort.Direction.fromString(paginationQuery.getOrder()), paginationQuery.getColumnsOrder().toArray(new String[paginationQuery.getColumnsOrder().size()])));
    }

    default String replaceQuery(PaginationQueryDTO paginationQuery) {
        String query = paginationQuery.getQuery();
        return String.format("%s%%", ("".equals(query) || "*".equals(query)) ? "%" : query);
    }

    default PaginationResultDTO<D> toPaginationResult(Page<E> page) {
        PaginationResultDTO result = new PaginationResultDTO();
        result.setData(toDTOS(page.getContent()));
        result.setTotalRows(page.getTotalElements());
        result.setPageSize(page.getSize());
        result.setPageNumber(page.getNumber());
        return result;
    }
}
