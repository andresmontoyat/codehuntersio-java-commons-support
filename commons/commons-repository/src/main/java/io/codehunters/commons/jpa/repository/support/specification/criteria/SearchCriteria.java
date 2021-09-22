package io.codehunters.commons.jpa.repository.support.specification.criteria;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SearchCriteria {

    private String attribute;

    private SearchOperation operation;

    private boolean isOr;

    private List<Object> values;
}
