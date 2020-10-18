package io.codehunters.commons.security.totp;

/**
 * Copyright (c) 2011 IETF Trust and the persons identified as
 * authors of the code. All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, is permitted pursuant to, and subject to the license
 * terms contained in, the Simplified BSD License set forth in Section
 * 4.c of the IETF Trust's Legal Provisions Relating to IETF Documents
 * (http://trustee.ietf.org/license-info).
 */

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/**
 * This is an example implementation of the TOTP algorithm.
 * Visit https://tools.ietf.org/html/rfc6238 for more information.
 *
 * @author Johan Rydell, PortWise, Inc.
 */
public class TOTP {

    private static final String HASH_SHA512 = "HmacSHA512";
    private static final String ALGORITHM = "RAW";
    private static final int[] DIGITS_POWER
            // 0  1   2    3     4      5       6        7         8
            = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    private Clock clock;

    public TOTP() {
        this.clock = new Clock();
    }

    public TOTP(int interval) {
        this.clock = new Clock(interval);
    }

    /**
     * This method uses the JCE to provide the crypto algorithm.
     * HMAC computes a Hashed Message Authentication Code with the
     * crypto hash algorithm as a parameter.
     *
     * @param secret:   the bytes to use for the HMAC key
     * @param interval: the interval time in millis
     */
    private byte[] hmac(byte[] secret, long interval) {
        try {
            Mac hmac = Mac.getInstance(HASH_SHA512);
            SecretKeySpec macKey =
                    new SecretKeySpec(secret, ALGORITHM);
            hmac.init(macKey);
            return hmac.doFinal(ByteBuffer.allocate(8).putLong(interval).array());
        } catch (GeneralSecurityException gse) {
            throw new UndeclaredThrowableException(gse);
        }
    }

    /**
     * This method converts a HEX string to Byte[]
     *
     * @param hex: the HEX string
     * @return: a byte array
     */
    private byte[] hexToBytes(String hex) {
        // Adding one byte to get the right conversion
        // Values starting with "0" can be converted
        byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();

        // Copy all the REAL bytes, not the "first"
        byte[] ret = new byte[bArray.length - 1];
        for (int i = 0; i < ret.length; i++)
            ret[i] = bArray[i + 1];
        return ret;
    }

    /**
     * This method generates a TOTP value for the given
     * set of parameters.
     *
     * @param secret: the shared secret, HEX encoded
     * @return: a numeric String in base 10 that includes
     */
    public String now(String secret) {
        return generate(secret, Digits.SIX, clock.getCurrentInterval());
    }

    /**
     * This method generates a TOTP value for the given
     * set of parameters.
     *
     * @param secret:    the shared secret, HEX encoded
     * @param digits: number of digits to return
     * @return: a numeric String in base 10 that includes
     */
    public String now(String secret, Digits digits) {
        return generate(secret, digits, clock.getCurrentInterval());
    }

    /**
     * This method generates a TOTP value for the given
     * set of parameters.
     *
     * @param secret:   the shared secret, HEX encoded
     * @param digits:
     * @param interval: a value that reflects a time
     * @return returnDigits: a numeric String in base 10 that includes number of digits to return
     */
    private String generate(String secret, Digits digits, long interval) {
        String result = null;
        int codeDigits = digits.getDigit();
        // Using the counter
        // First 8 bytes are for the movingFactor
        // Compliant with base RFC 4226 (HOTP)
        // Get the HEX in a Byte[]
        byte[] k = hexToBytes(secret);
        byte[] hash = hmac(k, interval);

        // put selected bytes into result int
        int offset = hash[hash.length - 1] & 0xf;

        int binary =
                ((hash[offset] & 0x7f) << 24) |
                        ((hash[offset + 1] & 0xff) << 16) |
                        ((hash[offset + 2] & 0xff) << 8) |
                        (hash[offset + 3] & 0xff);

        int otp = binary % DIGITS_POWER[codeDigits];

        result = Integer.toString(otp);
        while (result.length() < codeDigits) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * This method verify a TOTP value
     *
     * @param otp
     * @return true or false validation
     */
    public boolean verify(String secret, String otp, Digits digits) {
        long currentInterval = clock.getCurrentInterval();
        int pastResponse = Math.max(1, 0);

        for (int i = pastResponse; i >= 0; --i) {
            String candidate = generate(secret, digits, currentInterval - i);
            if (candidate.equals(otp)) {
                return true;
            }
        }
        return false;
    }

    enum Digits {
        FOUR(4),
        SIX(6),
        EIGHT(8);

        private int digit;

        Digits(int digit) {
            this.digit = digit;
        }

        public int getDigit() {
            return digit;
        }
    }
}
