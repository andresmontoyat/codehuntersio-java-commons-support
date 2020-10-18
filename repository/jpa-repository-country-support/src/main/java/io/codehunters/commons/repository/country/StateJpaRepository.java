package io.codehunters.commons.repository.country;

import io.codehunters.commons.repository.country.domain.CountryEntity;
import io.codehunters.commons.repository.country.domain.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateJpaRepository extends JpaRepository<StateEntity, Long> {

    @Query("SELECT c FROM StateEntity c WHERE UPPER(c.name) LIKE UPPER(:name)")
    Optional<List<CountryEntity>> findAllByNameLike(@Param("name") String name);
}