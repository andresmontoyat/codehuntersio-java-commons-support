package io.codehunters.commons.repository.country.support;

import io.codehunters.commons.repository.country.support.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
