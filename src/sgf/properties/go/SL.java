package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.ValueList;
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
 * Time: 13:21:45
 * To change this template use File | Settings | File Templates.
 */
public class SL extends sgf.properties.SL {

    private static ValueType valueType = new ValueList<Point>(GoValueTypes.POINT);

    private List<Point> points = new ArrayList<Point>();

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        Point point = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        points.add(point);
        return true;
    }

    public Object getSGFValue() {
        return Lists.join(points,"][");
    }

    public int getSize() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }
}
