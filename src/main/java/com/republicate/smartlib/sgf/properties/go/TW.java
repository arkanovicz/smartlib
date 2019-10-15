package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueEList;
import com.republicate.smartlib.sgf.types.go.GoValueTypes;
import com.republicate.smartlib.sgf.types.go.Point;
import com.republicate.smartlib.sgf.MarkupProperty;

import java.util.List;
import java.util.ArrayList;

import com.republicate.smartlib.util.GoUtils;
import com.republicate.smartlib.util.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 11:48:29
 * To change this template use File | Settings | File Templates.
 */
public class TW extends MarkupProperty {

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
