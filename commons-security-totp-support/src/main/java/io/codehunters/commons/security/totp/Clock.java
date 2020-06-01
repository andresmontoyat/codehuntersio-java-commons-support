package io.codehunters.commons.security.totp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Clock {

    public static final int DEFAULT_INTERVAL = 30;

    private int interval;
    private Calendar calendar;

    public Clock() {
        interval = DEFAULT_INTERVAL;
    }

    public long getCurrentInterval() {
        calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        return ((calendar.getTimeInMillis() / 1000) / interval);
    }
}
