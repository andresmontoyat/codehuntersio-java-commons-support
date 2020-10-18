package io.codehunters.commons.repository.otp.domain.converter;

import io.codehunters.commons.repository.converter.support.DomainAttributeConverter;
import io.codehunters.commons.repository.converter.support.DomainAttributeConverterException;
import io.codehunters.commons.repository.otp.domain.enums.OtpServiceType;
import io.codehunters.commons.util.Util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class ServiceTypeConverter extends DomainAttributeConverter implements AttributeConverter<List<OtpServiceType>, String> {

    @Override
    public String convertToDatabaseColumn(List<OtpServiceType> OtpServiceTypes) {
        try {
            return mapper.writeValueAsString(OtpServiceTypes);
        } catch (Exception e) {
            throw new DomainAttributeConverterException(String.format("An error occurred while trying to convert the map string to json %s", OtpServiceTypes), e);
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
