package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.Compose;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.ValueList;
import com.republicate.smartlib.sgf.types.ComposedSimpleText;
import com.republicate.smartlib.sgf.types.go.Point;
import com.republicate.smartlib.sgf.types.go.GoValueTypes;
import com.republicate.smartlib.sgf.types.go.Annotation;

import java.util.List;
import java.util.ArrayList;

import com.republicate.smartlib.util.GoUtils;
import com.republicate.smartlib.util.Lists;

/**
 * Writes the given text on the board. The text should be
 * centered around the given point.
 */
public class LB extends com.republicate.smartlib.sgf.properties.LB {

    private List<Annotation> annotations = new ArrayList<Annotation>();

    private static ValueType valueType = null;

    static {
        Compose<Point, ComposedSimpleText> compType = new Compose<Point, ComposedSimpleText>(GoValueTypes.POINT, ValueTypes.COMPOSED_SIMPLE_TEXT);
        valueType = new ValueList<Compose<Point, ComposedSimpleText>>(compType);
    }

    public ValueType getValueType() {
        return valueType;
    }

    public Object getSGFValue() {
        return Lists.join(annotations,"][");
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 2) return false;
        Point point = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        String text = ComposedSimpleText.unescape(value.get(1));
        annotations.add(new Annotation(point,text));
        return true;
    }

    public int removeValue(List<String> value) {
        if(value.size() != 2) return -1;
        Point point = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        String text = ComposedSimpleText.unescape(value.get(1));
        annotations.remove(new Annotation(point,text));
        return annotations.size();
    }

    
    public int getSize() {
        return annotations.size();
    }

    public Annotation get(int index) {
        return annotations.get(index);
    }
}
