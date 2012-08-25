package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.ValueEList;
import sgf.types.None;
import sgf.types.ValueTypes;
import sgf.types.Or;
import sgf.types.go.GoValueTypes;
import sgf.types.go.Point;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * View only part of the board.
 */
public class VW extends sgf.properties.VW {

    private List<Point> points = new ArrayList<Point>();

    private static ValueType valueType = new Or<None,ValueEList<Point>>(ValueTypes.NONE,new ValueEList<Point>(GoValueTypes.POINT));

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        // TODO the left test shouldn't be needed anymore
        return value.size() == 0 || GoUtils.addEListValue(value,points,Point.class);
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
