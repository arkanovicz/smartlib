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
 * Simple line form one point to the other.
 */
public class LN extends com.republicate.smartlib.sgf.properties.LN {

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

    public int removeValue(List<String> value) {
        if(value.size() != 2) return -1;
        Point start = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        Point end = new Point(GoUtils.parseCoord(value.get(1).charAt(0)),GoUtils.parseCoord(value.get(1).charAt(1)));
        lines.remove(new Pair(start,end));
        return lines.size();
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
