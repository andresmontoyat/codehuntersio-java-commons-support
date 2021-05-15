package io.codehunters.commons.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
        return prefix + uuid();
    }

}