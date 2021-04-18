package io.codehunters.commons.util.password;

import java.util.Random;

public class PasswordUtil {

    public static final int RANDOM_PASS = 8;

    public static final char[] NUMERIC = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '*', '-', '_',
            '$', '@', '#', '.', '=', '{', '}'};

    public static String randomPass() {
        return randomPass(RANDOM_PASS);
    }

    public static String randomPass(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return sb.toString();
    }

    public static String randomNumericPass() {
        return randomNumericPass(RANDOM_PASS);
    }

    public static String randomNumericPass(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(NUMERIC[random.nextInt(NUMERIC.length)]);
        }
        return sb.toString();
    }
}
