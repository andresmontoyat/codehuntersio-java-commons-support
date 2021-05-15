package io.codehunters.commons.util.date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrettyDate {

    public static String pretty(Date date) {
        double diff = subtractDateToSeconds(DateUtil.getDate(DateUtil.FORMAT_HOUR), date);
        double dayDiff = Math.floor(diff / 86400);

        if (dayDiff == 0) {
            if (diff < 60) {
                return "just now";
            } else if (diff < 120) {
                return "1 minute ago";
            } else if (diff < 3600) {
                return (int) Math.floor(diff / 60) + " minutes ago";
            } else
                return (int) Math.floor(diff / 3600) + " hours ago";
        } else if (dayDiff == 1) {
            return "Yesterday";
        } else if (dayDiff < 7) {
            return dayDiff + " Yesterday";
        }

        return (int) Math.ceil(dayDiff / 7) + " weeks ago";
    }

    public static double subtractDateToSeconds(Date date1, Date date2) {
        return (double) (date1.getTime() - date2.getTime()) / 1000f;
    }
}
