package io.codehunters.commons.util.password;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordUtil {

    public static final String HAS_NUMBERS_REGEX = "^(?=.*[0-9])(?=\\S+$).{0,}$";
    public static final String HAS_LOWER_CASE_REGEX = "^(?=.*[a-z])(?=\\S+$).{0,}$";
    public static final String HAS_UPPER_CASE_REGEX = "^(?=.*[A-Z])(?=\\S+$).{0,}$";
    public static final String HAS_SPECIAL_CHAR_CASE_REGEX = "^(?=.*[@#$%^&+=\\-_\\*])(?=\\S+$).{0,}$";
    public static final String LENGTH_REGEX = ".{8,%d}$";

    public static final String FULL_REGEX = "^"
            + "(?=.*[0-9])"
            + "(?=.*[a-z])"
            + "(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=\\-_\\*])"
            + "(?=\\S+$)";

    public static final int MIN_LENGTH = 8;
    public static final int MAX_LENGTH = 10;

    protected static final char[] NUMERIC = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    protected static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '*', '-', '_',
            '$', '@', '#', '.', '=', '&'};

    public static String randomPass() throws NoSuchAlgorithmException {
        return randomPass(MAX_LENGTH);
    }

    public static String randomPass(int length) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb;
        do {
            sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(CHARS[random.nextInt(CHARS.length)]);
            }
        } while (!isValidPassword(sb.toString(), MAX_LENGTH));

        return sb.toString();
    }

    public static String randomNumericPass() throws NoSuchAlgorithmException {
        return randomNumericPass(MAX_LENGTH);
    }

    public static String randomNumericPass(int length) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(NUMERIC[random.nextInt(NUMERIC.length)]);
        }
        return sb.toString();
    }

    public static boolean isValidPassword(String password) {
        return isValidPassword(password, MAX_LENGTH);
    }

    public static boolean isValidPassword(String password, int maxLength) {
        StringBuilder builder = new StringBuilder(FULL_REGEX);
        builder.append(String.format(LENGTH_REGEX, maxLength));
        return patternMatches(builder.toString(), password);
    }

    public static boolean hasNumbers(String password) {
        return patternMatches(HAS_NUMBERS_REGEX, password);
    }

    public static boolean hasLowerCase(String password) {
        return patternMatches(HAS_LOWER_CASE_REGEX, password);
    }

    public static boolean hasUpperCase(String password) {
        return patternMatches(HAS_UPPER_CASE_REGEX, password);
    }

    public static boolean hasSpecialCharCase(String password) {
        return patternMatches(HAS_SPECIAL_CHAR_CASE_REGEX, password);
    }

    private static boolean patternMatches(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
