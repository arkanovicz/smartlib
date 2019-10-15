package com.republicate.smartlib.sgf.types.go;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 01:43:16
 * To change this template use File | Settings | File Templates.
 */
public class Stone extends Point implements com.republicate.smartlib.sgf.types.Stone {

    public Stone() {
    }

    public String getName() {
        return "Stone";
    }

    public Stone(int col,int row) {
        super(col,row);
    }

}
