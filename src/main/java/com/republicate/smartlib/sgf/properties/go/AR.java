package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.Compose;
import com.republicate.smartlib.sgf.types.ValueList;
import com.republicate.smartlib.sgf.types.Pair;
import com.republicate.smartlib.sgf.types.go.Point;
import com.republicate.smartlib.sgf.types.go.GoValueTypes;

import java.util.List;
import java.util.ArrayList;

import com.republicate.smartlib.util.GoUtils;
import com.republicate.smartlib.util.Lists;

/**
 * Arrow pointing FROM the first point TO the second point.
 */
public class AR extends com.republicate.smartlib.sgf.properties.AR {

    private List<Pair<Point>> arrows = new ArrayList<Pair<Point>>();

    private static ValueType valueType = new ValueList<Compose<Point,Point>>(new Compose<Point,Point>(GoValueTypes.POINT,GoValueTypes.POINT));

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 2) return false;
        Point start = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        Point end = new Point(GoUtils.parseCoord(value.get(1).charAt(0)),GoUtils.parseCoord(value.get(1).charAt(1)));
        arrows.add(new Pair(start,end));
        return true;
    }

    public int removeValue(List<String> value) {
        if(value.size() != 2) return -1;
        Point start = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        Point end = new Point(GoUtils.parseCoord(value.get(1).charAt(0)),GoUtils.parseCoord(value.get(1).charAt(1)));
        arrows.remove(new Pair(start,end));
        return arrows.size();
    }

    public Object getSGFValue() {
        return Lists.join(arrows,"][");
    }

    public int getSize() {
        return arrows.size();
    }

    public Pair<Point> get(int index) {
        return arrows.get(index);
    }
}
