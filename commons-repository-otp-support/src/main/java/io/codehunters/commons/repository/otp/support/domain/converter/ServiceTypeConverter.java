package io.codehunters.commons.repository.otp.support.domain.converter;

import io.codehunters.commons.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.repository.otp.support.domain.enums.OTPServiceType;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class ServiceTypeConverter extends DomainAttributeConverter implements AttributeConverter<List<OTPServiceType>, String> {

    @Override
    public String convertToDatabaseColumn(List<OTPServiceType> OTPServiceTypes) {
        try {
            return mapper.writeValueAsString(OTPServiceTypes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", OTPServiceTypes), e);
        }
    }

    @Override
    public List<OTPServiceType> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(List.class, OTPServiceType.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set of string values %s", json), e);
        }
    }
}
