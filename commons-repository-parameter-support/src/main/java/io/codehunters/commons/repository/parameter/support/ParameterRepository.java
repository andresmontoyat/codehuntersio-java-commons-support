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

    @Query("SELECT p FROM Parameter p WHERE p.application = :application AND p.group = :group")
    Optional<List<Parameter>> findAllByApplicationEqualsAndGroupEquals(@Param("application") String application, @Param("group") String group);

    @Query("SELECT p FROM Parameter p WHERE p.application = :application AND p.group = :group AND p.enabled = :enabled")
    Optional<List<Parameter>> findAllByApplicationEqualsAndGroupEqualsAndEnabledEquals(@Param("application") String application, @Param("group") String group, @Param("enabled") Boolean enabled);

    @Query("SELECT p FROM Parameter p WHERE p.application = :application AND p.group = :group AND p.code = :code")
    Optional<Parameter> findByApplicationEqualsAndGroupEqualsAndCodeEquals(@Param("application") String application, @Param("group") String group, @Param("code") String code);

    @Query("SELECT p FROM Parameter p WHERE p.application = :application AND p.group = :group AND p.code = :code AND p.enabled = :enabled")
    Optional<Parameter> findByApplicationEqualsAndGroupEqualsAndCodeEqualsAndEnabledEquals(@Param("application") String application, @Param("group") String group, @Param("code") String code, @Param("enabled") Boolean enabled);
}
