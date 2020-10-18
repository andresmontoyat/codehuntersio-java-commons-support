package io.codehunters.commons.jpa.mapper;

import io.codehunters.commons.dto.pagination.PageQueryDTO;
import io.codehunters.commons.dto.pagination.PageResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SuppressWarnings("unchecked")
public interface PageDTOMapper<D, E> extends DTOMapper<D, E>   {

    default PageRequest toPageRequest(PageQueryDTO paginationQuery) {
        return PageRequest.of(paginationQuery.getPage(), Math.min(1000, paginationQuery.getSize()), Sort.by(Sort.Direction.fromString(paginationQuery.getOrder()), paginationQuery.getColumnOrder()));
    }

    default String replaceQuery(PageQueryDTO paginationQuery) {
        String query = paginationQuery.getQuery();
        return String.format("%s%%", ("".equals(query) || "*".equals(query)) ? "%" : query);
    }

    default PageResultDTO toPaginationResult(Page page) {
        PageResultDTO result = new PageResultDTO();
        result.setData(toDTOS(page.getContent()));
        result.setTotalRows(page.getTotalElements());
        result.setPageSize(page.getSize());
        result.setPageNumber(page.getNumber());
        return result;
    }
}
