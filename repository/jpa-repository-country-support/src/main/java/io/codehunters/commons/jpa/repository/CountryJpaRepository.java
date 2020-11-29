package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {

    @Query("SELECT c FROM CountryEntity c ORDER BY c.name ASC")
    @Override
    List<CountryEntity> findAll();

    @Query("SELECT c FROM CountryEntity c WHERE UPPER(c.name) LIKE UPPER(:name) AND c.status = :status")
    Page<CountryEntity> findAllByNameLike(@Param("name") String name, @Param("status") String status, Pageable pageable);
}