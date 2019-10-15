package com.republicate.smartlib.sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 13:01:01
 * To change this template use File | Settings | File Templates.
 */
public class Double implements ValueType {

    public String getPattern() {
        return "(1|2)";
    }

    public String getName() {
        return "Double";
    }
}
