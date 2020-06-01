package io.codehunters.commons.repository.otp.support.domain.support.converter;

import io.codehunters.commons.enums.otp.support.OtpServiceType;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.domain.support.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class OtpServiceTypeConverter extends DomainAttributeConverter implements AttributeConverter<List<OtpServiceType>, String> {

    @Override
    public String convertToDatabaseColumn(List<OtpServiceType> serviceTypes) {
        try {
            return mapper.writeValueAsString(serviceTypes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", serviceTypes), e);
        }
    }

    @Override
    public List<OtpServiceType> convertToEntityAttribute(String json) {
        try {
            return !Util.isNull(json) ? mapper.readValue(json, collectionType(List.class, OtpServiceType.class)) : null;
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert json to set of string values %s", json), e);
        }
    }
}
