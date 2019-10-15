package com.republicate.sgf.properties.go;

import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueEList;
import com.republicate.sgf.types.go.GoValueTypes;
import com.republicate.sgf.types.go.Point;

import java.util.List;
import java.util.ArrayList;

import com.republicate.util.GoUtils;
import com.republicate.util.Lists;

/**
 * Clear the given points on the board.
 */
public class AE extends com.republicate.sgf.properties.AE {

    private List<Point> points = new ArrayList<Point>();

    private static ValueType valueType = new ValueEList<Point>(GoValueTypes.POINT);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        return GoUtils.addEListValue(value,points,Point.class);
    }

    public int removeValue(List<String> value)
    {
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
