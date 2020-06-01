package io.codehunters.commons.repository.domain.support.converter;

import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter
public class MapStringKeyWithStringValueConverter extends DomainAttributeConverter implements AttributeConverter<Map<String, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, String> mapStrings) {
        try {
            return mapper.writeValueAsString(mapStrings);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", mapStrings), e);
        }
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, mapType(Map.class, String.class, String.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to map string %s", json), e);
        }
    }
}
