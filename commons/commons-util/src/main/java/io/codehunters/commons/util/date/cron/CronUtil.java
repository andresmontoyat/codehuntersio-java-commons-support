package io.codehunters.commons.util.date.cron;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CronUtil {

    public static String convertDateToCronExpression(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        return String.format("%d %d %d %d %d ? %d", seconds, minute, hour, day, month, year);
    }
}
