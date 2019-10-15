package com.republicate.sgf.types;

/**
 */
public class SimpleText implements ValueType {

    public String getPattern() {
        return "((?:[^\\]\\\\]|(?:\\\\.))*)";
    }

    public String getName() {
        return "SimpleText";
    }

    public static String escape(String input) {
        return input.replaceAll("([\\]\\\\])","\\\\$1");
    }

    public static String unescape(String input) {
        String ret = input.replace("\\\\(?:\n|\r|(?:\n\r)|(?:\r\n))","");
        ret = ret.replace("(?:\n|\r|(?:\n\r)|(?:\r\n))"," ");
        ret = ret.replaceAll("\\\\(.)","$1");
        return ret;
    }
    
}
