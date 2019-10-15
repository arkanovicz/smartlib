package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueEList;
import com.republicate.smartlib.sgf.types.None;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.Or;
import com.republicate.smartlib.sgf.types.go.GoValueTypes;
import com.republicate.smartlib.sgf.types.go.Point;

import java.util.List;
import java.util.ArrayList;

import com.republicate.smartlib.util.GoUtils;
import com.republicate.smartlib.util.Lists;

/**
 * View only part of the board.
 */
public class VW extends com.republicate.smartlib.sgf.properties.VW {

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
