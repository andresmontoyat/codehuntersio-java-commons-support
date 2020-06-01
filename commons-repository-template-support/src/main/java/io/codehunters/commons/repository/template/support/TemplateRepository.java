package io.codehunters.commons.repository.template.support;

import io.codehunters.commons.repository.template.support.domain.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateRepository  extends PagingAndSortingRepository<Template, Long> {

    @Query("SELECT t FROM Template t WHERE t.application = :application AND t.code = :code AND t.enabled = :enabled")
    Optional<Template> findByApplicationEqualsAndCodeEqualsAndEnabledEquals(@Param("application") String application, @Param("code") String code, @Param("enabled") Boolean enabled);

    @Query("SELECT t FROM Template t WHERE t.application = :application AND t.parameter1 = :parameter1")
    Optional<List<Template>> findAllByApplicationEqualsAndParameter1Equals(@Param("application") String application, @Param("parameter1") String parameter1);

    @Query("SELECT t FROM Template t WHERE t.application = :application AND t.parameter1 = :parameter1 AND t.parameter2 = :parameter2")
    Optional<List<Template>> findAllByApplicationEqualsAndParameter1EqualsAnAndParameter2Equals(@Param("application") String application, @Param("parameter1") String parameter1, @Param("parameter2") String parameter2);
}
