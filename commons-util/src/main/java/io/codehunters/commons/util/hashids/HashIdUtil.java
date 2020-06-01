package io.codehunters.commons.util.hashids;

import org.hashids.Hashids;

public class HashIdUtil {

    private static Hashids hashids = new Hashids("++MyS4alt$**", 10);

    public static String encode() {
        return hashids.encode(System.currentTimeMillis());
    }

    public static String encode(long... numbers) {
        return hashids.encode(numbers);
    }

    public static long[] decode(String hash) {
        return hashids.decode(hash);
    }

}
