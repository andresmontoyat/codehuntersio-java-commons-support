package io.codehunters.commons.jpa.repository.template;

import io.codehunters.commons.jpa.repository.template.domain.TemplateJpaEntities;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateJpaRepository extends PagingAndSortingRepository<TemplateJpaEntities, Long> {

    Optional<TemplateJpaEntities> findByCodeEquals(String code);

    Optional<List<TemplateJpaEntities>> findAllByParameter1Equals(String parameter1);

    Optional<TemplateJpaEntities> findByCodeEqualsAndParameter1Equals(String code, String parameter1);

    Optional<List<TemplateJpaEntities>> findAllByParameter1EqualsAndParameter2Equals(String parameter1, String parameter2);

    Optional<TemplateJpaEntities> findByCodeEqualsAndParameter1EqualsAndParameter2Equals(String code, String parameter1, String parameter2);

    Optional<List<TemplateJpaEntities>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(String parameter1, String parameter2, String parameter3);

    Optional<TemplateJpaEntities> findByCodeEqualsAndParameter1EqualsAndParameter2EqualsAndParameter3Equals(String code, String parameter1, String parameter2, String parameter3);

}
