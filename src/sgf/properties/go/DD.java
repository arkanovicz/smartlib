package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.go.GoValueTypes;
import sgf.types.go.Point;
import sgf.types.ValueEList;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * Dim (grey out) the given points.
 */
public class DD extends sgf.properties.DD {

    private List<Point> points = new ArrayList<Point>();

    private static ValueType valueType = new ValueEList<Point>(GoValueTypes.POINT);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        return GoUtils.addEListValue(value,points,Point.class);
    }

    public int removeValue(List<String> value) {
        GoUtils.removeEListValue(value,points,Point.class);
        return points.size();
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
