package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.Compose;
import sgf.types.ValueList;
import sgf.types.Pair;
import sgf.types.go.Point;
import sgf.types.go.GoValueTypes;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 13:11:21
 * To change this template use File | Settings | File Templates.
 */
public class LN extends sgf.properties.LN {

    private List<Pair<Point>> lines = new ArrayList<Pair<Point>>();

    private static ValueType valueType = new ValueList<Compose<Point,Point>>(new Compose<Point,Point>(GoValueTypes.POINT,GoValueTypes.POINT));

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 2) return false;
        Point start = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        Point end = new Point(GoUtils.parseCoord(value.get(1).charAt(0)),GoUtils.parseCoord(value.get(1).charAt(1)));
        lines.add(new Pair(start,end));
        return true;
    }

    public Object getValue() {
        return Lists.join(lines,"][");
    }

    public int getSize() {
        return lines.size();
    }

    public Pair<Point> get(int index) {
        return lines.get(index);
    }
}
