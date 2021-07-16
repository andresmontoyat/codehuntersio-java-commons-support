package io.codehunters.commons.security.totp;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.TimeZone;

@Getter
@Setter
public class Clock {

    public static final int DEFAULT_INTERVAL = 30;
    public static final String DEFAULT_TIMEZONE = "UTC";

    private final int interval;

    private final String timeZone;

    public Clock() {
        this.interval = DEFAULT_INTERVAL;
        this.timeZone = DEFAULT_TIMEZONE;
    }

    public Clock(int interval) {
        this.interval = interval;
        this.timeZone = DEFAULT_TIMEZONE;
    }

    public Clock(int interval, String timeZone) {
        this.interval = interval;
        this.timeZone = timeZone;
    }

    public long getCurrentInterval() {
        return ((Calendar.getInstance(TimeZone.getTimeZone(timeZone)).getTimeInMillis() / 1000l) / interval);
    }
}
