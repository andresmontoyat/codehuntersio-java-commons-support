package io.codehunters.commons.jpa.repository.converter.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

import java.util.Collection;
import java.util.Map;

public abstract class DomainAttributeConverter {

    protected ObjectMapper mapper = new ObjectMapper();
    
    protected CollectionType collectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    protected MapType mapType(Class<? extends Map> mapClass, Class<?> elementKey, Class<?> elementValue) {
        return mapper.getTypeFactory().constructMapType(mapClass, elementKey, elementValue);
    }
}
