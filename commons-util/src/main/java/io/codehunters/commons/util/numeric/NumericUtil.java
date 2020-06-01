package io.codehunters.commons.util.numeric;

import io.codehunters.commons.util.Util;

import java.math.BigDecimal;

public class NumericUtil {

    public static BigDecimal toBigDecimal(String value) {
        BigDecimal bigDecimal = new BigDecimal((String) Util.ifNull(value, "0"));
        return bigDecimal;
    }

    public static Integer parseInt(String value) {
        return Integer.valueOf(toBigDecimal(value).intValue());
    }

    public static Long parseLong(String value) {
        return Long.valueOf(toBigDecimal(value).longValue());
    }

    public static Double parseDouble(String value) {
        return Double.valueOf(toBigDecimal(value).doubleValue());
    }

    public static String formatDouble(Double value) {
        return formatDouble(value, "%.2f");
    }

    public static String formatDouble(Double value, String format) {
        return String.format(format, value);
    }

    public static String formatLong(Long value) {
        return String.valueOf(value);
    }

    public static String formatLong(Long value, String format) {
        return String.format(format, value);
    }

}
