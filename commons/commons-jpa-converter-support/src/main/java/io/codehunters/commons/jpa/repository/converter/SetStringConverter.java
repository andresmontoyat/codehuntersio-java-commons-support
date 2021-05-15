package io.codehunters.commons.jpa.repository.converter;

import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter
public class SetStringConverter extends DomainAttributeConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> setStrings) {
        try {
            return converterMapper.writeValueAsString(setStrings);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the set strings to json %s", setStrings), e);
        }
    }

    @Override
    public Set<String> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? converterMapper.readValue(json, collectionType(Set.class, String.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set strings %s", json), e);
        }
    }
}
