package io.codehunters.commons.util.string;

import org.apache.commons.lang3.StringUtils;

public class MasqueradeUtil {

    public static final String DEFAULT_WILDCARD = "*";

    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 1;
    public static final int POSITION_CENTER = 2;

    public static String mask(String text, int position, int extractStartIndex, int extractEndIndex) {
        return mask(text, position, extractStartIndex, extractEndIndex, DEFAULT_WILDCARD);
    }

    public static String mask(String text, int position, int extractStartIndex, int extractEndIndex, String wildcard) {
        switch (position) {
            case POSITION_RIGHT:
                String rtoken = text.substring(extractStartIndex, extractEndIndex);
                return StringUtils.rightPad(rtoken, text.length(), wildcard);
            case POSITION_LEFT:
                String ltoken = text.substring(extractStartIndex, extractEndIndex);
                return StringUtils.leftPad(ltoken, text.length(), wildcard);
            case POSITION_CENTER:
                String startToken = text.substring(0, extractStartIndex);
                String endToken = text.substring(extractEndIndex);
                return StringUtils.rightPad(startToken, (text.substring(0, extractEndIndex).length()), wildcard).concat(endToken);
        }
        return null;
    }
}
