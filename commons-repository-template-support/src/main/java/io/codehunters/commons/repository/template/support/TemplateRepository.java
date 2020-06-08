package io.codehunters.commons.repository.template.support;

import io.codehunters.commons.repository.template.support.domain.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {

    @Query("SELECT t FROM Template t WHERE t.group = :group")
    Optional<List<Template>> findAllByGroupEquals(@Param("group") String group);

    @Query("SELECT t FROM Template t WHERE t.group = :group AND t.code = :code")
    Optional<Template> findByGroupEqualsAndCodeEquals(@Param("group") String group, @Param("code") String code);

    @Query("SELECT t FROM Template t WHERE t.group = :group AND t.code = :code AND t.parameter1 = :parameter1")
    Optional<Template> findByGroupEqualsAndCodeEqualsAndParameter1Equals(@Param("group") String group, @Param("code") String code, @Param("parameter1") Long parameter1);

    @Query("SELECT t FROM Template t WHERE t.group = :group AND t.code = :code AND t.parameter1 = :parameter1 AND t.parameter2 = :parameter2")
    Optional<Template> findByGroupEqualsAndCodeEqualsAndParameter1EqualsAndParameter2Equals(@Param("group") String group, @Param("code") String code, @Param("parameter1") Long parameter1, @Param("parameter2") Long parameter2);

    @Query("SELECT t FROM Template t WHERE t.group = :group AND t.code = :code AND t.parameter1 = :parameter1 AND t.parameter2 = :parameter2 AND t.parameter3 = :parameter3")
    Optional<Template> findByGroupEqualsAndCodeEqualsAndParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("group") String group, @Param("code") String code, @Param("parameter1") Long parameter1, @Param("parameter2") Long parameter2, @Param("parameter3") Long parameter3);
}
