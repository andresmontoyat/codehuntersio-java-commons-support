package io.codehunters.commons.service;

import io.codehunters.commons.dto.pagination.PageQueryDTO;
import io.codehunters.commons.dto.pagination.PageResultDTO;

public interface PaginationOperationServiceSupport<ID, D> extends CrudOperationServiceSupport<ID, D> {

    PageResultDTO findAll(PageQueryDTO query);
}
