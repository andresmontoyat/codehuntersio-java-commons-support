package io.codehunters.commons.jpa.mapper.pagination;

import io.codehunters.commons.dto.mapper.DTOMapper;
import io.codehunters.commons.dto.pagination.PaginationQueryDTO;
import io.codehunters.commons.dto.pagination.PaginationResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public interface PaginationMapperJpa<D, E> extends DTOMapper<D, E> {

    int DEFAULT_PAGE_SIZE = 1000;

    default Pageable toPageRequest(PaginationQueryDTO paginationQuery) {
        if (Optional.ofNullable(paginationQuery.getColumns()).isPresent()) {
            return PageRequest
                    .of(paginationQuery.getPage(), Math.min(DEFAULT_PAGE_SIZE, paginationQuery.getSize()),
                            Sort.by(paginationQuery.getColumns()
                                    .entrySet()
                                    .stream()
                                    .map(entrySet -> new Sort.Order(Sort.Direction.fromString(entrySet.getValue()), entrySet.getKey())).collect(Collectors.toList())));
        }

        return PageRequest.of(paginationQuery.getPage(), Math.min(DEFAULT_PAGE_SIZE, paginationQuery.getSize()));
    }

    default String replaceQuery(PaginationQueryDTO paginationQuery) {
        String query = paginationQuery.getQuery();
        return String.format("%%%s%%", ("".equals(query) || "*".equals(query)) ? "%" : query);
    }

    default PaginationResultDTO<D> toPaginationResult(Page<E> page) {
        PaginationResultDTO<D> result = new PaginationResultDTO<>();
        result.setData(toDTOS(page.getContent()));
        result.setRows(page.getTotalElements());
        result.setSize(page.getSize());
        result.setPage(page.getNumber());
        return result;
    }


}
