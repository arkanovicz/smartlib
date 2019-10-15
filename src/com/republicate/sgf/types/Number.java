package com.republicate.sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 13:31:50
 * To change this template use File | Settings | File Templates.
 */
public class Number implements ValueType {

    public String getPattern() {
        return "((?:\\+|-)?\\d+)";
    }

    public String getName() {
        return "Number";
    }
}
