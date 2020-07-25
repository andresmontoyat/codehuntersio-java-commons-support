package io.codehunters.commons.repository.country;

import io.codehunters.commons.repository.country.domain.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    @Query("SELECT c FROM Country c WHERE UPPER(c.name) LIKE UPPER(:name)")
    Optional<List<Country>> findAllByNameLike(@Param("name") String name);

    @Query("SELECT c FROM Country c WHERE c.enabled = :enabled")
    Optional<List<Country>> findAllByEnabledEquals(@Param("enabled") Boolean enabled);
}
