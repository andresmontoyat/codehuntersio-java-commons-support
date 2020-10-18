package io.codehunters.commons.repository.notification.domain.converter;

import io.codehunters.commons.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.repository.notification.domain.enums.DestinationType;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter
public class DestinationTypeConverter extends DomainAttributeConverter implements AttributeConverter<Map<DestinationType, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<DestinationType, String> destinationTypes) {
        try {
            return mapper.writeValueAsString(destinationTypes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", destinationTypes), e);
        }
    }

    @Override
    public Map<DestinationType, String> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, mapType(Map.class, DestinationType.class, String.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to map of string values %s", json), e);
        }
    }
}
