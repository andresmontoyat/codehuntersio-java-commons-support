package io.codehunters.commons.util;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class Util {

    public static boolean isNull(Object object) {
        if (object != null) {
            if ((object instanceof String) && "".equals(object))
                return true;
            else if (((object instanceof Object[])) && ((Object[]) object).length <= 0)
                return true;
            else if (((object instanceof Collection)) && ((Collection<?>) object).isEmpty())
                return true;
            else if (((object instanceof Map)) && ((Map) object).isEmpty())
                return true;
            return false;
        }

        return true;
    }

    public static Object ifNull(Object parameter, Object result) {
        if (isNull(parameter)) {
            return result;
        }
        return parameter;
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }

}
