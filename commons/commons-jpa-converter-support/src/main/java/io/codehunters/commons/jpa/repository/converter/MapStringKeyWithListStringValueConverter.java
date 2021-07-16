package io.codehunters.commons.jpa.repository.converter;

import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.jpa.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;
import java.util.Map;

@Converter
public class MapStringKeyWithListStringValueConverter extends DomainAttributeConverter implements AttributeConverter<Map<String, List<String>>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, List<String>> mapStrings) {
        try {
            return converterMapper.writeValueAsString(mapStrings);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", mapStrings), e);
        }
    }

    @Override
    public Map<String, List<String>> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? converterMapper.readValue(json, mapType(Map.class, String.class, List.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to map string %s", json), e);
        }
    }
}
