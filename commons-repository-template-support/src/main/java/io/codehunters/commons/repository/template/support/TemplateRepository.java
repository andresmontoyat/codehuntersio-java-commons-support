package io.codehunters.commons.repository.template.support;

import io.codehunters.commons.repository.template.support.domain.Template;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository  extends PagingAndSortingRepository<Template, Long> {

}
