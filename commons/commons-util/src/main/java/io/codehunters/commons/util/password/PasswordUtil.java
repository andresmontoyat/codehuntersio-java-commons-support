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

    public static final String PASSWORD_HAS_NUMBERS = "^(?=.*[0-9])(?=\\S+$).{0,}$";
    public static final String PASSWORD_HAS_LOWER_CASE = "^(?=.*[a-z])(?=\\S+$).{0,}$";
    public static final String PASSWORD_HAS_UPPER_CASE = "^(?=.*[A-Z])(?=\\S+$).{0,}$";
    public static final String PASSWORD_HAS_SPECIAL_CHAR_CASE = "^(?=.*[@#$%^&+=\\-_\\*])(?=\\S+$).{0,}$";
    public static final String PASSWORD_LENGTH = ".{8,%d}$";

    public static final String PASSWORD_FULL_REGEX = "^"
            + "(?=.*[0-9])"
            + "(?=.*[a-z])"
            + "(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=\\-_\\*])"
            + "(?=\\S+$)";

    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 10;

    public static final char[] NUMERIC = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '*', '-', '_',
            '$', '@', '#', '.', '=', '&'};

    public static String randomPass() {
        return randomPass(PASSWORD_MAX_LENGTH);
    }

    public static String randomPass(int length) {
        Random random = new Random();
        StringBuilder sb;
        do {
            sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(CHARS[random.nextInt(CHARS.length)]);
            }
        } while (!isValidPassword(sb.toString(), PASSWORD_MAX_LENGTH));

        return sb.toString();
    }

    public static String randomNumericPass() throws NoSuchAlgorithmException {
        return randomNumericPass(PASSWORD_MAX_LENGTH);
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
        return isValidPassword(password, PASSWORD_MAX_LENGTH);
    }

    public static boolean isValidPassword(String password, int maxLength) {
        StringBuilder builder = new StringBuilder(PASSWORD_FULL_REGEX);
        builder.append(String.format(PASSWORD_LENGTH, maxLength));
        return patternMatches(builder.toString(), password);
    }

    public static boolean hasNumbers(String password) {
        return patternMatches(PASSWORD_HAS_NUMBERS, password);
    }

    public static boolean hasLowerCase(String password) {
        return patternMatches(PASSWORD_HAS_LOWER_CASE, password);
    }

    public static boolean hasUpperCase(String password) {
        return patternMatches(PASSWORD_HAS_UPPER_CASE, password);
    }

    public static boolean hasSpecialCharCase(String password) {
        return patternMatches(PASSWORD_HAS_SPECIAL_CHAR_CASE, password);
    }

    private static boolean patternMatches(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(hasSpecialCharCase("andre$momn"));
    }

}
