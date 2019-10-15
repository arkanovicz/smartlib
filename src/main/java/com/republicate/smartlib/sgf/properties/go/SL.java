package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueList;
import com.republicate.smartlib.sgf.types.go.Point;
import com.republicate.smartlib.sgf.types.go.GoValueTypes;

import java.util.List;
import java.util.ArrayList;

import com.republicate.smartlib.util.GoUtils;
import com.republicate.smartlib.util.Lists;

/**
 * Selected points.
 */
public class SL extends com.republicate.smartlib.sgf.properties.SL {

    private static ValueType valueType = new ValueList<Point>(GoValueTypes.POINT);

    private List<Point> points = new ArrayList<Point>();

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1 && value.size() != 2) return false;
        return GoUtils.populatePoints(points,value.get(0),value.size() == 1 ? null : value.get(1));
    }

    public int removeValue(List<String> value) {
        if(value.size() != 1 && value.size() != 2) return -1;
        GoUtils.clearPoints(points,value.get(0),value.size() == 1 ? null : value.get(1));
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
