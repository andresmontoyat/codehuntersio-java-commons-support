package io.codehunters.commons.repository.parameter.support;

import io.codehunters.commons.repository.parameter.support.domain.Parameter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends PagingAndSortingRepository<Parameter, Long> {

}
