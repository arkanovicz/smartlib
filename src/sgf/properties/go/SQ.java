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
 * Marks the given points with a square.
 */
public class SQ extends sgf.properties.SQ {

    private static ValueType valueType = new ValueList<Point>(GoValueTypes.POINT);

    private List<Point> points = new ArrayList<Point>();

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1 && value.size() != 2) return false;
        return GoUtils.populatePoints(points,value.get(0),value.size() == 1 ? null : value.get(1));
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
