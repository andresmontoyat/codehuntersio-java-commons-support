package io.codehunters.commons.util.password;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordUtil {

    private static final int RANDOM_PASS = 8;

    private static final char[] NUMERIC = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '*', '-', '_',
            '$', '@', '#', '.', '=', '{', '}'};

    public static String randomPass() throws NoSuchAlgorithmException {
        return randomPass(RANDOM_PASS);
    }

    public static String randomPass(int length) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return sb.toString();
    }

    public static String randomNumericPass() throws NoSuchAlgorithmException {
        return randomNumericPass(RANDOM_PASS);
    }

    public static String randomNumericPass(int length) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(NUMERIC[random.nextInt(NUMERIC.length)]);
        }
        return sb.toString();
    }
}
