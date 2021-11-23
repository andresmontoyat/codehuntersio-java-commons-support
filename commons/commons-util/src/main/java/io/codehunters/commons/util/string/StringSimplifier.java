package io.codehunters.commons.util.string;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.Normalizer;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @Author Andreas Petersson
 * https://stackoverflow.com/questions/1453171/remove-diacritical-marks-ń-ǹ-ň-ñ-ṅ-ņ-ṇ-ṋ-ṉ-̈-ɲ-ƞ-ᶇ-ɳ-ȵ-from-unicode-chars
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringSimplifier {
    public static final char DEFAULT_REPLACE_CHAR = '_';
    public static final String DEFAULT_REPLACE = String.valueOf(DEFAULT_REPLACE_CHAR);
    private static final Map<String, String> NONDIACRITICS = Map.ofEntries(Map.entry(".", ""),
            Map.entry("\"", ""), Map.entry("'", ""),
            //Keep relevant characters as seperation
            Map.entry(" ", DEFAULT_REPLACE),
            Map.entry("]", DEFAULT_REPLACE),
            Map.entry("[", DEFAULT_REPLACE),
            Map.entry(")", DEFAULT_REPLACE),
            Map.entry("(", DEFAULT_REPLACE),
            Map.entry("=", DEFAULT_REPLACE),
            Map.entry("!", DEFAULT_REPLACE),
            Map.entry("/", DEFAULT_REPLACE),
            Map.entry("\\", DEFAULT_REPLACE),
            Map.entry("&", DEFAULT_REPLACE),
            Map.entry(",", DEFAULT_REPLACE),
            Map.entry("?", DEFAULT_REPLACE),
            Map.entry("°", DEFAULT_REPLACE), //Remove ?? is diacritic?
            Map.entry("|", DEFAULT_REPLACE),
            Map.entry("<", DEFAULT_REPLACE),
            Map.entry(">", DEFAULT_REPLACE),
            Map.entry(";", DEFAULT_REPLACE),
            Map.entry(":", DEFAULT_REPLACE),
            Map.entry("_", DEFAULT_REPLACE),
            Map.entry("#", DEFAULT_REPLACE),
            Map.entry("~", DEFAULT_REPLACE),
            Map.entry("+", DEFAULT_REPLACE),
            Map.entry("*", DEFAULT_REPLACE),
            Map.entry("%", DEFAULT_REPLACE),

            //Replace non-diacritics as their equivalent characters
            Map.entry("\u0141", "l"), // BiaLystock
            Map.entry("\u0142", "l"),// Bialystock
            Map.entry("ß", "ss"),
            Map.entry("æ", "ae"),
            Map.entry("ø", "o"),
            Map.entry("©", "c"),
            Map.entry("\u00D0", "d"),// All Ð ð from http://de.wikipedia.org/wiki/%C3%90
            Map.entry("\u00F0", "d"),
            Map.entry("\u0110", "d"),
            Map.entry("\u0111", "d"),
            Map.entry("\u0189", "d"), Map.entry("\u0256", "d"),
            Map.entry("\u00DE", "th"), // thorn Þ
            Map.entry("\u00FE", "th"));

    public static String simplifiedString(String orig) {
        String str = orig;
        if (str == null) {
            return null;
        }
        str = stripDiacritics(str);
        str = stripNonDiacritics(str);
        if (str.length() == 0) {
            // Ugly special case to work around non-existing empty strings
            // in Oracle. Store original crapstring as simplified.
            // It would return an empty string if Oracle could store it.
            return orig;
        }
        return str.toLowerCase();
    }

    private static String stripNonDiacritics(String orig) {
        StringBuilder ret = new StringBuilder();
        String lastchar = null;
        for (int i = 0; i < orig.length(); i++) {
            String source = orig.substring(i, i + 1);
            String replace = NONDIACRITICS.get(source);
            String toReplace = replace == null ? String.valueOf(source) : replace;
            if (DEFAULT_REPLACE.equals(lastchar) && DEFAULT_REPLACE.equals(toReplace)) {
                toReplace = "";
            } else {
                lastchar = toReplace;
            }
            ret.append(toReplace);
        }
        if (ret.length() > 0 && DEFAULT_REPLACE_CHAR == ret.charAt(ret.length() - 1)) {
            ret.deleteCharAt(ret.length() - 1);
        }
        return ret.toString();
    }

    /*
    Special regular expression character ranges relevant for simplification -> see http://docstore.mik.ua/orelly/perl/prog3/ch05_04.htm
    InCombiningDiacriticalMarks: special marks that are part of "normal" ä, ö, î etc..
        IsSk: Symbol, Modifier see http://www.fileformat.info/info/unicode/category/Sk/list.htm
        IsLm: Letter, Modifier see http://www.fileformat.info/info/unicode/category/Lm/list.htm
     */
    public static final Pattern DIACRITICS_AND_FRIENDS
            = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");


    private static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }

    public static void main(String[] args) {
        System.out.println(simplifiedString("Carlos Andrés ñeñe %tpt"));
    }
}
