package io.codehunters.commons.repository.domain.support.converter;

import io.codehunters.commons.enums.security.support.AuthorizedGrantType;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter
public class SetAuthorizedGrantTypeConverter extends DomainAttributeConverter implements AttributeConverter<Set<AuthorizedGrantType>, String> {

    @Override
    public String convertToDatabaseColumn(Set<AuthorizedGrantType> authorizedGrantTypes) {
        try {
            return mapper.writeValueAsString(authorizedGrantTypes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert set grant types values to json %s", authorizedGrantTypes), e);
        }
    }

    @Override
    public Set<AuthorizedGrantType> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(Set.class, AuthorizedGrantType.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set of grant types values %s", json), e);
        }
    }
}
