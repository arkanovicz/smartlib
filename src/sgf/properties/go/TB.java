package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.ValueEList;
import sgf.types.go.GoValueTypes;
import sgf.types.go.Point;
import sgf.Property;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 11:48:29
 * To change this template use File | Settings | File Templates.
 */
public class TB extends Property {

    private List<Point> points = new ArrayList<Point>();

    private static ValueType valueType = new ValueEList<Point>(GoValueTypes.POINT);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        return GoUtils.addEListValue(value,points,Point.class);
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
