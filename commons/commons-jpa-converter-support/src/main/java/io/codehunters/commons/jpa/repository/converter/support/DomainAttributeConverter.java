package io.codehunters.commons.jpa.repository.converter.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

import java.util.Collection;
import java.util.Map;

public abstract class DomainAttributeConverter {

    protected final ObjectMapper converterMapper = new ObjectMapper();
    
    protected CollectionType collectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return converterMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    protected MapType mapType(Class<? extends Map> mapClass, Class<?> elementKey, Class<?> elementValue) {
        return converterMapper.getTypeFactory().constructMapType(mapClass, elementKey, elementValue);
    }
}
