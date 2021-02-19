package io.codehunters.commons.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrettyDateSerializer extends JsonSerializer<Date> {

    private static final DateFormat dateFormat = new SimpleDateFormat("EE. dd MMM. yyyy");

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(dateFormat.format(value));
    }
}
