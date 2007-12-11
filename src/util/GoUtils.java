package util;

import sgf.types.go.Point;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 11:20:37
 * To change this template use File | Settings | File Templates.
 */
public class GoUtils {

    public static int parseCoord(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 1;
        } else {
            return -1;
        }
    }

    public static char charCoord(int c) {
        char ch = (char)('a' - 1 + c);
        if(ch > 'z') {
            ch = (char)('A' - 27 + c);
        }
        return ch;
    }

    private static <T extends Point> T makeValue(Class<T> clazz,int col,int row) {
        try {
            T value = clazz.newInstance();
            value.setCol(col);
            value.setRow(row);
            return value;
        } catch(InstantiationException ie) {
            Logger.log(ie);
        } catch(IllegalAccessException iae) {
            Logger.log(iae);
        }
        return null;
    }

    public static <T extends Point> boolean addEListValue(List<String> value,List<T> points,Class<T> type) {
        if(value.size() == 1) {
            T point = makeValue(type,GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
            points.add(point);
            return true;
        } else if (value.size() == 2) {
            T start = makeValue(type,GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
            T end = makeValue(type,GoUtils.parseCoord(value.get(1).charAt(0)),GoUtils.parseCoord(value.get(1).charAt(1)));
            for(int col = start.getCol() ; col <= end.getCol() ; col++) {
                for (int row = start.getRow() ; row <= end.getRow() ; row++) {
                    points.add(makeValue(type,col,row));
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
