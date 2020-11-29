package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.CityEntity;
import io.codehunters.commons.jpa.repository.domain.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityJpaRepository extends JpaRepository<CityEntity, Long> {

    @Query("SELECT c FROM CityEntity c WHERE UPPER(c.name) LIKE UPPER(:name)")
    Optional<List<CountryEntity>> findAllByNameLike(@Param("name") String name);
}