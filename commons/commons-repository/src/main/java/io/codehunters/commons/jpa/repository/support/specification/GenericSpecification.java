package io.codehunters.commons.jpa.repository.support.specification;

import io.codehunters.commons.jpa.repository.support.specification.criteria.SearchCriteria;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Object value = searchCriteria.getValues().get(0);
        Class _class = value.getClass();

        switch (searchCriteria.getOperation()) {
            case EQUALITY:
                return criteriaBuilder.equal(root.get(searchCriteria.getAttribute()), value);
            case NEGATION:
                return criteriaBuilder.notEqual(root.get(searchCriteria.getAttribute()), value);
            case LIKE:
                return criteriaBuilder.like(criteriaBuilder.upper(root.get(searchCriteria.getAttribute())), criteriaBuilder.upper(criteriaBuilder.literal("%" + value + "%")));
            case BETWEEN:
                return criteriaBuilder.between(root.get(searchCriteria.getAttribute()), value.toString(), value.toString());
            case IN:
                return root.get(searchCriteria.getAttribute()).in(searchCriteria.getValues());
            default:
                throw new UnsupportedOperationException("Operation not supported yet");
        }
    }

}
