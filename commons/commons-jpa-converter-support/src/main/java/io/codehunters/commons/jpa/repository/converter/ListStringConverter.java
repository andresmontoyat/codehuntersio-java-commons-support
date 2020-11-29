package io.codehunters.commons.jpa.repository.converter;

import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class ListStringConverter extends DomainAttributeConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> setStrings) {
        try {
            return mapper.writeValueAsString(setStrings);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the list strings to json %s", setStrings), e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(List.class, String.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to list strings %s", json), e);
        }
    }
}
