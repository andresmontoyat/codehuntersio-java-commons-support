package io.codehunters.commons.repository.domain.support.converter;

import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter
public class SetStringConverter extends DomainAttributeConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> stringSet) {
        try {
            return mapper.writeValueAsString(stringSet);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert set of string values to json %s", stringSet), e);
        }
    }

    @Override
    public Set<String> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(Set.class, String.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set of string values %s", json), e);
        }
    }
}
