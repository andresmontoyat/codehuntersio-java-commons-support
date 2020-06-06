package io.codehunters.commons.security.util.crypto;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptUtils {
    /**
     * Encode plain text
     *
     * @param plaintext the plaintexto to encode
     * @return the plaintext
     */
    public static String encode(String plaintext) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plaintext, salt);
    }
}
