package com.republicate.sgf.types;

/**
 */
public class ComposedSimpleText extends SimpleText {

    public String getPattern() {
        return "((?:[^\\]]|(?:\\\\[\\]]))*)";
    }

    public static String escape(String input) {
        return input.replaceAll("([\\]])","\\\\$1");
    }
}
