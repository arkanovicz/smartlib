package com.republicate.sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 12:51:24
 * To change this template use File | Settings | File Templates.
 */
public interface ValueTypes {

    public static final Color COLOR = new Color();
    public static final ComposedSimpleText COMPOSED_SIMPLE_TEXT = new ComposedSimpleText();
    public static final Double DOUBLE = new Double();
    public static final None NONE = new None();
    public static final Number NUMBER = new Number();
    public static final Real REAL = new Real();
    public static final SimpleText SIMPLE_TEXT = new SimpleText();
    public static final Text TEXT = new Text();
}
