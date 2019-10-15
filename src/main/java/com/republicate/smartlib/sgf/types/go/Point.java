package com.republicate.smartlib.sgf.types.go;

import com.republicate.smartlib.util.GoUtils;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 01:39:59
 * To change this template use File | Settings | File Templates.
 */
public class Point implements com.republicate.smartlib.sgf.types.Point {

    private int col;
    private int row;

    public Point() {
        col = row = -1;
    }

    public Point (int c,int r) {
        col = c;
        row = r;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int c) {
        col = c;
    }

    public void setRow(int r) {
        row = r;
    }

    public String getPattern() {
        return "([a-zA-Z][a-zA-Z])";
    }

    public String getName() {
        return "Point";
    }

    public String toString() {
        return ""+ GoUtils.charCoord(col)+GoUtils.charCoord(row);
    }

    public boolean equals(Object other)
    {
        if(other == null || !(other instanceof Point)) return false;
        return col == ((Point)other).getCol() && row == ((Point)other).getRow();
    }
}
