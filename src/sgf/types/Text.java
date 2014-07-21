package sgf.types;

import util.Logger;

/**
 */
public class Text implements ValueType {

    public String getPattern() {
        return "((?>\\\\.|[^\\]\\\\])*)";
    }

    public String getName() {
        return "Text";
    }

    public static String escape(String input) {
        return input.replaceAll("([\\]\\\\])","\\\\$1");
    }

    public static String unescape(String input) {
        String ret = input.replace("\\\\(?:\n|\r|(?:\n\r)|(?:\r\n))","");
        ret = ret.replace("(?:\n|\r|(?:\n\r)|(?:\r\n))","\n");
        ret = ret.replaceAll("\\\\(.)","$1");
        return ret;
    }

}
