package io.codehunters.commons.repository.country;

import io.codehunters.commons.repository.country.domain.CountryEntity;
import io.codehunters.commons.repository.country.domain.NeighborhoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NeighborhoodJpaRepository extends JpaRepository<NeighborhoodEntity, Long> {

    @Query("SELECT c FROM NeighborhoodEntity c WHERE UPPER(c.name) LIKE UPPER(:name)")
    Optional<List<CountryEntity>> findAllByNameLike(@Param("name") String name);
}