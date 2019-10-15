package com.republicate.smartlib.sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 13:20:18
 * To change this template use File | Settings | File Templates.
 */
public class None implements ValueType {

    public String getPattern() {
        return "";
    }

    public String getName() {
        return "None";
    }
}
