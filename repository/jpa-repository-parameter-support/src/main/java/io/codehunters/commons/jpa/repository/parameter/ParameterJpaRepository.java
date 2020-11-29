package io.codehunters.commons.jpa.repository.parameter;

import io.codehunters.commons.jpa.repository.parameter.domain.ParameterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParameterJpaRepository extends PagingAndSortingRepository<ParameterEntity, Long> {

    @Query("SELECT p FROM ParameterEntity p WHERE p.code = :code")
    Optional<ParameterEntity> findByCodeEquals(@Param("code") String code);

    @Query("SELECT p FROM ParameterEntity p WHERE p.parameter1 = :parameter1")
    Optional<List<ParameterEntity>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT p FROM ParameterEntity p WHERE p.parameter1 = :parameter1 AND p.parameter2 = :parameter2")
    Optional<List<ParameterEntity>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT p FROM ParameterEntity p WHERE p.parameter1 = :parameter1 AND p.parameter2 = :parameter2 AND p.parameter3 = :parameter3")
    Optional<List<ParameterEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}
