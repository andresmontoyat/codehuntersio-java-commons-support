package io.codehunters.commons.repository.domain.support.converter;

import io.codehunters.commons.enums.security.support.Scope;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter
public class SetScopeConverter extends DomainAttributeConverter implements AttributeConverter<Set<Scope>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Scope> scopes) {
        try {
            return mapper.writeValueAsString(scopes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert set of scopes values to json %s", scopes), e);
        }
    }

    @Override
    public Set<Scope> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(Set.class, Scope.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set of scopes values %s", json), e);
        }
    }
}
