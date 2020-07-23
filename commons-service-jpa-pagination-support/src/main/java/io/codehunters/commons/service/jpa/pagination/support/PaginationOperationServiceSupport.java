package io.codehunters.commons.service.jpa.pagination.support;

import io.codehunters.commons.dto.jpa.pagination.support.PaginationQueryDTO;
import io.codehunters.commons.dto.jpa.pagination.support.PaginationResultDTO;
import io.codehunters.commons.service.support.CrudOperationServiceSupport;

public interface PaginationOperationServiceSupport<ID, D> extends CrudOperationServiceSupport<ID, D> {

    PaginationResultDTO findAll(PaginationQueryDTO query);
}
