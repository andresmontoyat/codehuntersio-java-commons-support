package io.codehunters.commons.util.date;

import io.codehunters.commons.util.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String FORMAT = "yyyy-MM-dd";
    public static final String FORMAT_CODE = "yyyyMMddHHmm";

    public static DateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    public static String format(DateFormat dateFormat, Date date) {
        return dateFormat.format(date);
    }

    public static Date parse(DateFormat dateFormat, String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDate() {
        return getDate(FORMAT, new Date());
    }

    public static Date getDate(String format) {
        return getDate(format, new Date());
    }

    public static Date getDate(String format, String date) {
        if (!Util.isNull(date))
            return parse(getDateFormat(format), date);
        return null;
    }

    public static Date getDate(String format, long time) {
        DateFormat dateFormat = getDateFormat(format);

        try {
            return dateFormat.parse(format(dateFormat, new Date(time)));
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDate(String format, Date date) {
        if (!Util.isNull(date)) {
            DateFormat dateFormat = getDateFormat(format);
            return parse(dateFormat, format(dateFormat, date));
        }

        return null;
    }

    public static String getDateToString() {
        return getDateToString(FORMAT, new Date());
    }

    public static String getDateToString(String format) {
        return getDateToString(format, new Date());
    }

    public static String getDateToString(String format, String date) {
        if (!Util.isNull(date)) {
            DateFormat dateFormat = getDateFormat(format);
            return getDateToString(format, parse(dateFormat, date));
        }
        return null;
    }

    public static String getDateToString(String format, Date date) {
        if (!Util.isNull(date)) {
            return format(getDateFormat(format), date);
        }

        return null;
    }

    private static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    public static int compareTo(Date date) {
        return compareTo(date, getDate());
    }

    public static int compareTo(Date date, Date date2) {
        if (date2 == null)
            return 1;
        return date.compareTo(date2);
    }

    public static int compareTo(Date date, Date date2, String format) {
        return compareTo(getDate(format, date), getDate(format, date2));
    }

    public static Date parseDate(String value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(value));
        return calendar.getTime();
    }

    public static Date dateAddDays(int days) {
        return updateCalendar(getCalendar(new Date()), Calendar.DAY_OF_MONTH, days);
    }

    public static Date dateAddDays(int days, Date date) {
        return updateCalendar(getCalendar(date), Calendar.DAY_OF_MONTH, days);
    }

    private static Date updateCalendar(Calendar calendar, int type, int val) {
        calendar.add(type, val);
        return calendar.getTime();
    }

}
