package io.codehunters.commons.jpa.repository.support.specification;

import io.codehunters.commons.jpa.repository.support.specification.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericSpecification<T> implements Specification<T> {

    private SearchCriteria searchCriteria;

    public GenericSpecification(final SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        switch (searchCriteria.getOperation()) {
            case EQUALITY:
                return criteriaBuilder.equal(root.get(searchCriteria.getAttribute()), searchCriteria.getValues().get(0));
            case IN:
                return root.get(searchCriteria.getAttribute()).in(searchCriteria.getValues());
        }

        return null;
    }

}
