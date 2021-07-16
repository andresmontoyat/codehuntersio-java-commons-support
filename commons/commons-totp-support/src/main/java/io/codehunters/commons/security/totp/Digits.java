package io.codehunters.commons.security.totp;

public enum Digits {
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
