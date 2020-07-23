package io.codehunters.commons.repository.parameter.support;

import io.codehunters.commons.repository.parameter.support.domain.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParameterRepository extends PagingAndSortingRepository<Parameter, Long> {

    @Query("SELECT p FROM Parameter p WHERE p.code = :code")
    Optional<Parameter> findByCodeEquals(@Param("code") String code);

    @Query("SELECT p FROM Parameter p WHERE p.parameter1 = :parameter1")
    Optional<List<Parameter>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT p FROM Parameter p WHERE p.parameter1 = :parameter1 AND p.parameter2 = :parameter2")
    Optional<List<Parameter>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT p FROM Parameter p WHERE p.parameter1 = :parameter1 AND p.parameter2 = :parameter2 AND p.parameter3 = :parameter3")
    Optional<List<Parameter>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}
