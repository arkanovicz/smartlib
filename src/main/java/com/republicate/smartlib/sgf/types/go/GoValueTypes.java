package com.republicate.smartlib.sgf.types.go;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 12:52:24
 * To change this template use File | Settings | File Templates.
 */
public interface GoValueTypes extends com.republicate.smartlib.sgf.types.ValueTypes {
    
    public static Move MOVE = new Move();
    public static Move PASS = new Move(-1,-1);
    public static Point POINT = new Point();
    public static Stone STONE = new Stone();
}
