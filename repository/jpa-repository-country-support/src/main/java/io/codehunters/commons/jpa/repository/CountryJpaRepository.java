package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {

    @Query("SELECT c FROM CountryEntity c ORDER BY c.name ASC")
    @Override
    List<CountryEntity> findAll();

    @Query("SELECT c FROM CountryEntity c WHERE c.enabled = :enabled ORDER BY c.name ASC")
    List<CountryEntity> findAllByEnabledEquals(@Param("enabled") Boolean enabled);

    @Query("SELECT c FROM CountryEntity c WHERE UPPER(c.name) LIKE UPPER(:name) AND c.enabled = :enabled")
    Page<CountryEntity> findAllByNameLike(@Param("name") String name, @Param("enabled") Boolean enabled, Pageable pageable);
}