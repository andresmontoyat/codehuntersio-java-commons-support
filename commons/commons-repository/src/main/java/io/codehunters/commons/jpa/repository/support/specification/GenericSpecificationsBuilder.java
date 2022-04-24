package io.codehunters.commons.jpa.repository.support.specification;

import io.codehunters.commons.jpa.repository.support.specification.criteria.SearchCriteria;
import io.codehunters.commons.jpa.repository.support.specification.criteria.SearchOperation;
import io.codehunters.commons.util.Util;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericSpecificationsBuilder<T> {

    private final List<SearchCriteria> params;

    private final List<Specification<T>> specifications;

    public GenericSpecificationsBuilder() {
        this.params = new ArrayList<>();
        this.specifications = new ArrayList<>();
    }

    public GenericSpecificationsBuilder<T> with(final String attribute, final SearchOperation operation, final Object value) {
        return with(attribute, operation, Boolean.FALSE, Arrays.asList(value));
    }

    public GenericSpecificationsBuilder<T> with(final String attribute, final SearchOperation operation, final List<Object> values) {
        return with(attribute, operation, Boolean.FALSE, values);
    }

    public GenericSpecificationsBuilder<T> with(final String attribute, final SearchOperation operation, final boolean isOr, final Object value) {
        return with(attribute, operation, isOr, Arrays.asList(value));
    }

    public GenericSpecificationsBuilder<T> with(final String attribute, final SearchOperation operation, final boolean isOr, final List<? extends java.io.Serializable> values) {
        params.add(SearchCriteria.builder()
                .attribute(attribute)
                .operation(operation)
                .isOr(isOr)
                .values(values)
                .build());
        return this;
    }

    public GenericSpecificationsBuilder<T> with(Specification<T> specification) {
        specifications.add(specification);
        return this;
    }

    public Specification<T> build() {
        Specification<T> root = null;

        if (!Util.isNull(params)) {
            root = new GenericSpecification<>(params.get(0));

            for (int i = 1; i < params.size(); i++) {
                SearchCriteria criteria = params.get(i);
                root = criteria.isOr()
                        ? Specification.where(root).or(new GenericSpecification<>(criteria))
                        : Specification.where(root).and(new GenericSpecification<>(criteria));
            }
        }

        if (!Util.isNull(specifications)) {
            int i = 0;
            if (root == null) {
                root = specifications.get(++i);
            }

            for (; i < specifications.size(); i++) {
                root = Specification.where(root).and(specifications.get(i));
            }
        }

        return root;
    }
}