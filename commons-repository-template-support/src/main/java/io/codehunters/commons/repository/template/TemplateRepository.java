package io.codehunters.commons.repository.template;

import io.codehunters.commons.repository.template.domain.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {

    @Query("SELECT t FROM Template t WHERE t.code = :code")
    Optional<List<Template>> findByCodeEquals(@Param("code") String code);

    @Query("SELECT t FROM Template t WHERE t.parameter1 = :parameter1")
    Optional<List<Template>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT t FROM Template t WHERE t.parameter1 = :parameter1 AND t.parameter2 = :parameter2")
    Optional<List<Template>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT t FROM Template t WHERE t.parameter1 = :parameter1 AND t.parameter2 = :parameter2 AND t.parameter3 = :parameter3")
    Optional<List<Template>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
    
}
