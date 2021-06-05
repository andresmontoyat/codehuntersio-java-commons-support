package io.codehunters.commons.jpa.repository.template;

import io.codehunters.commons.jpa.repository.template.domain.TemplateJpaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateJpaRepository extends PagingAndSortingRepository<TemplateJpaEntity, Long> {

    Optional<TemplateJpaEntity> findByCodeEquals(String code);

    Optional<List<TemplateJpaEntity>> findAllByParameter1Equals(String parameter1);

    Optional<TemplateJpaEntity> findByCodeEqualsAndParameter1Equals(String code, String parameter1);

    Optional<List<TemplateJpaEntity>> findAllByParameter1EqualsAndParameter2Equals(String parameter1, String parameter2);

    Optional<TemplateJpaEntity> findByCodeEqualsAndParameter1EqualsAndParameter2Equals(String code, String parameter1, String parameter2);

    Optional<List<TemplateJpaEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(String parameter1, String parameter2, String parameter3);

    Optional<TemplateJpaEntity> findByCodeEqualsAndParameter1EqualsAndParameter2EqualsAndParameter3Equals(String code, String parameter1, String parameter2, String parameter3);

}
