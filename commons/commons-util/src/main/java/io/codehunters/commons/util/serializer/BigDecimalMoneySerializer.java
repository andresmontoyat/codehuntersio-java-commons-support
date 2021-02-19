package io.codehunters.commons.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BigDecimalMoneySerializer extends JsonSerializer<BigDecimal> {

    private static final NumberFormat numberFormat = new DecimalFormat("###,###.##");

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(numberFormat.format(value.setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

}
