package io.codehunters.commons.jpa.repository.converter;

import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter
public class MapStringKeyWithObjectValueConverter extends DomainAttributeConverter implements AttributeConverter<Map<String, Object>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> mapStrings) {
        try {
            return mapper.writeValueAsString(mapStrings);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", mapStrings), e);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, mapType(Map.class, String.class, Object.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to map string %s", json), e);
        }
    }
}
