package io.codehunters.commons.util;

import java.util.Optional;
import java.util.UUID;

public class Util {

    public static boolean isNull(Object object) {
        return !Optional.ofNullable(object).isPresent();
    }

    public static Object ifNull(Object parameter, Object result) {
        if (isNull(parameter)) {
            return parameter;
        }
        return result;
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }

}
